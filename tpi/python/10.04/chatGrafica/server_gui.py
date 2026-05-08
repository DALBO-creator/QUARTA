import socket
import threading
import queue
import tkinter as tk
from tkinter import scrolledtext

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET
SOCKET_TYPE    = socket.SOCK_STREAM
SERVER_HOST    = '0.0.0.0'
SERVER_PORT    = 5000

# ===== CODA per comunicazione thread → GUI =====
msg_queue = queue.Queue()

# ===== SOCKET GLOBALS =====
client_socket = None
buffer_server = b""

# ===== FUNZIONI DI COMUNICAZIONE =====
def invia_socket(sock, testo):
    sock.sendall((testo + "\n").encode('utf-8'))

def ricevi_socket(sock):
    global buffer_server
    while b"\n" not in buffer_server:
        chunk = sock.recv(1024)
        if not chunk:
            return None
        buffer_server += chunk
    linea, buffer_server = buffer_server.split(b"\n", 1)
    return linea.decode('utf-8').strip()

# ===== THREAD: ricezione messaggi =====
def thread_ricezione(sock):
    while True:
        msg = ricevi_socket(sock)
        if msg is None or msg.upper() == "FINE":
            msg_queue.put(("system", "[!] Il client ha chiuso la connessione."))
            msg_queue.put(("disconnect", ""))
            break
        msg_queue.put(("client", msg))

# ===== THREAD: attesa connessione =====
def thread_attesa(server_sock):
    global client_socket
    msg_queue.put(("system", "[3] In attesa di un client..."))
    try:
        client_socket, addr = server_sock.accept()
        msg_queue.put(("system", f"[4] Connessione accettata da {addr[0]}:{addr[1]}"))
        msg_queue.put(("connected", ""))
        t = threading.Thread(target=thread_ricezione, args=(client_socket,), daemon=True)
        t.start()
    except OSError:
        pass  # server chiuso

# ===== GUI =====
class ServerApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Chat TCP — SERVER")
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
        self.chat.tag_config('client', foreground='#89b4fa')
        self.chat.tag_config('tu',     foreground='#f5c2e7')

        # --- Barra di stato ---
        self.status_var = tk.StringVar(value="Stato: in attesa di connessione...")
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

        # --- Avvio server socket ---
        self.server_sock = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
        self.server_sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        self.server_sock.bind((SERVER_HOST, SERVER_PORT))
        self.server_sock.listen(1)
        self.aggiungi_messaggio("system", f"[1] Socket creato")
        self.aggiungi_messaggio("system", f"[2] Bind su porta {SERVER_PORT}")

        t = threading.Thread(target=thread_attesa, args=(self.server_sock,), daemon=True)
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
            invia_socket(client_socket, msg)
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
                self.status_var.set("Stato: client disconnesso")
            elif tipo == "client":
                self.aggiungi_messaggio("client", f"Client: {testo}")
            elif tipo == "system":
                self.aggiungi_messaggio("system", testo)
        self.root.after(100, self.poll_queue)

    def chiudi(self):
        try:
            if client_socket:
                client_socket.close()
            self.server_sock.close()
        except Exception:
            pass
        self.root.destroy()

# ===== MAIN =====
if __name__ == "__main__":
    root = tk.Tk()
    app = ServerApp(root)
    root.mainloop()
