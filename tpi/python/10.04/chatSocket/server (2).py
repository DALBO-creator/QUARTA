import socket
import threading

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET      # IPv4
SOCKET_TYPE    = socket.SOCK_STREAM  # TCP
SERVER_HOST    = '10.4.54.19FINE'        # Indirizzo di ascolto
SERVER_PORT    = 5000                # Porta di ascolto

# ===== FUNZIONI DI COMUNICAZIONE =====
buffer_server = b""

def invia(sock, testo):
    """Invia una stringa UTF-8 terminata da newline."""
    sock.sendall((testo + "\n").encode('utf-8'))

def ricevi(sock):
    """Riceve una riga terminata da newline e la restituisce pulita."""
    global buffer_server
    while b"\n" not in buffer_server:
        chunk = sock.recv(1024)
        if not chunk:
            return None
        buffer_server += chunk
    linea, buffer_server = buffer_server.split(b"\n", 1)
    return linea.decode('utf-8').strip()

# ===== THREAD: ricezione messaggi dal client =====
def ricevi_messaggi(sock, addr):
    """Ascolta i messaggi in arrivo dal client e li stampa."""
    while True:
        msg = ricevi(sock)
        if msg is None or msg.upper() == "FINE":
            print(f"\n[!] Client {addr} ha chiuso la connessione.")
            sock.close()
            break
        print(f"\n[Client] {msg}\nTu: ", end='', flush=True)

# ===== AVVIO SERVER =====
print("\n=== SERVER TCP - Chat ===")

# FASE 1: socket()
server = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
print("[1] Socket creato")

# FASE 2: bind()
server.bind(("0.0.0.0", SERVER_PORT))
print(f"[2] Bind su {SERVER_HOST}:{SERVER_PORT}")

# FASE 3: listen()
server.listen(1)
print("[3] In attesa di un client...\n")

try:
    # FASE 4: accept()
    client_socket, client_address = server.accept()
    print(f"[4] Connessione accettata da {client_address}\n")
    print("--- Chat avviata. Scrivi 'FINE' per chiudere. ---\n")

    # Avvia thread di ricezione
    t = threading.Thread(target=ricevi_messaggi, args=(client_socket, client_address), daemon=True)
    t.start()

    # Loop di invio messaggi
    while t.is_alive():
        msg = input("Tu: ").strip()
        if not msg:
            continue
        invia(client_socket, msg)
        if msg.upper() == "FINE":
            print("[*] Hai chiuso la chat.")
            break

except KeyboardInterrupt:
    print("\n\n[!] Server interrotto (Ctrl+C)")
finally:
    # FASE 5: close()
    server.close()
    print("[5] Socket server chiusa\n")
