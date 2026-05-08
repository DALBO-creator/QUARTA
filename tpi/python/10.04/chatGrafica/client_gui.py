import socket
import threading
import queue
import tkinter as tk
from tkinter import scrolledtext

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET
SOCKET_TYPE    = socket.SOCK_STREAM
SERVER_HOST    = '10.4.54.20'   # <-- cambia con l'IP del server
SERVER_PORT    = 5000

# ===== CODA per comunicazione thread → GUI =====
msg_queue = queue.Queue()

# ===== SOCKET GLOBALS =====
client_sock = None
buffer_client = b""

# ===== FUNZIONI DI COMUNICAZIONE =====
def invia_socket(sock, testo):
    sock.sendall((testo + "\n").encode('utf-8'))

def ricevi_socket(sock):
    global buffer_client
    while b"\n" not in buffer_client:
        chunk = sock.recv(1024)
        if not chunk:
            return None
        buffer_client += chunk
    linea, buffer_client = buffer_client.split(b"\n", 1)
    return linea.decode('utf-8').strip()

# ===== THREAD: ricezione messaggi =====
def thread_ricezione(sock):
    while True:
        msg = ricevi_socket(sock)
        if msg is None or msg.upper() == "FINE":
            msg_queue.put(("system", "[!] Il server ha chiuso la connessione."))
            msg_queue.put(("disconnect", ""))
            break
        msg_queue.put(("server", msg))

# ===== THREAD: connessione al server =====
def thread_connessione():
    global client_sock
    msg_queue.put(("system", f"[1] Socket creato"))
    msg_queue.put(("system", f"[2] Connessione a {SERVER_HOST}:{SERVER_PORT}..."))
    try:
        client_sock = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
        client_sock.connect((SERVER_HOST, SERVER_PORT))
        msg_queue.put(("system", f"[3] Connesso!"))
        msg_queue.put(("connected", ""))
        t = threading.Thread(target=thread_ricezione, args=(client_sock,), daemon=True)
        t.start()
    except Exception as e:
        msg_queue.put(("system", f"[Errore] Connessione fallita: {e}"))

# ===== GUI =====
class ClientApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Chat TCP — CLIENT")
        self.root.resizable(False, False)
        self.connected = False

        # --- Area chat ---
        self.chat = scrolledtext.ScrolledText(root, width=55, height=20,
                                              state='disabled', wrap='word',
                                              bg='#1e1e2e', fg='#cdd6f4',
                                              font=('Consolas', 10))
        self.chat.pack(padx=10, pady=(10, 5))

        # Tag colori
        self.chat.tag_config('system', foreground='#a6e3a1')
        self.chat.tag_config('server', foreground='#89b4fa')
        self.chat.tag_config('tu',     foreground='#f5c2e7')

        # --- Barra di stato ---
        self.status_var = tk.StringVar(value="Stato: connessione in corso...")
        tk.Label(root, textvariable=self.status_var, anchor='w',
                 font=('Consolas', 9), fg='#a6e3a1').pack(fill='x', padx=10)

        # --- Input + pulsante ---
        frame = tk.Frame(root)
        frame.pack(padx=10, pady=(0, 10), fill='x')

        self.entry = tk.Entry(frame, font=('Consolas', 10), state='disabled')
        self.entry.pack(side='left', fill='x', expand=True, padx=(0, 5))
        self.entry.bind('<Return>', lambda e: self.invia())

        self.btn = tk.Button(frame, text='Invia', command=self.invia,
                             state='disabled', width=8)
        self.btn.pack(side='right')

        # --- Avvia connessione in background ---
        t = threading.Thread(target=thread_connessione, daemon=True)
        t.start()

        self.root.protocol("WM_DELETE_WINDOW", self.chiudi)
        self.poll_queue()

    def aggiungi_messaggio(self, tag, testo):
        self.chat.config(state='normal')
        self.chat.insert('end', testo + "\n", tag)
        self.chat.see('end')
        self.chat.config(state='disabled')

    def invia(self):
        msg = self.entry.get().strip()
        if not msg or not self.connected:
            return
        self.entry.delete(0, 'end')
        try:
            invia_socket(client_sock, msg)
            self.aggiungi_messaggio("tu", f"Tu: {msg}")
            if msg.upper() == "FINE":
                self.chiudi()
        except Exception as e:
            self.aggiungi_messaggio("system", f"[Errore invio] {e}")

    def poll_queue(self):
        """Controlla la coda messaggi ogni 100ms (thread-safe con Tkinter)."""
        while not msg_queue.empty():
            tipo, testo = msg_queue.get()
            if tipo == "connected":
                self.connected = True
                self.entry.config(state='normal')
                self.btn.config(state='normal')
                self.status_var.set("Stato: connesso ✓")
                self.entry.focus()
            elif tipo == "disconnect":
                self.connected = False
                self.entry.config(state='disabled')
                self.btn.config(state='disabled')
                self.status_var.set("Stato: server disconnesso")
            elif tipo == "server":
                self.aggiungi_messaggio("server", f"Server: {testo}")
            elif tipo == "system":
                self.aggiungi_messaggio("system", testo)
        self.root.after(100, self.poll_queue)

    def chiudi(self):
        try:
            if client_sock:
                client_sock.close()
        except Exception:
            pass
        self.root.destroy()

# ===== MAIN =====
if __name__ == "__main__":
    root = tk.Tk()
    app = ClientApp(root)
    root.mainloop()
