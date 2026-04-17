import socket
import threading

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET      # IPv4
SOCKET_TYPE    = socket.SOCK_STREAM  # TCP
SERVER_HOST    = '10.4.54.20'        # Indirizzo del server
SERVER_PORT    = 5000                # Porta del server

# ===== FUNZIONI DI COMUNICAZIONE =====
buffer_client = b""

def invia(sock, testo):
    """Invia una stringa UTF-8 terminata da newline."""
    sock.sendall((testo + "\n").encode('utf-8'))

def ricevi(sock):
    """Riceve una riga terminata da newline e la restituisce pulita."""
    global buffer_client
    while b"\n" not in buffer_client:
        chunk = sock.recv(1024)
        if not chunk:
            return None
        buffer_client += chunk
    linea, buffer_client = buffer_client.split(b"\n", 1)
    return linea.decode('utf-8').strip()

# ===== THREAD: ricezione messaggi dal server =====
def ricevi_messaggi(sock):
    """Ascolta i messaggi in arrivo dal server e li stampa."""
    while True:
        msg = ricevi(sock)
        if msg is None or msg.upper() == "FINE":
            print(f"\n[!] Il server ha chiuso la connessione.")
            sock.close()
            break
        print(f"\n[Server] {msg}\nTu: ", end='', flush=True)

# ===== AVVIO CLIENT =====
print("\n=== CLIENT TCP - Chat ===")

# FASE 1: socket()
client = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
print("[1] Socket creato")

# FASE 2: connect()
client.connect((SERVER_HOST, SERVER_PORT))
print(f"[2] Connesso a {SERVER_HOST}:{SERVER_PORT}\n")
print("--- Chat avviata. Scrivi 'FINE' per chiudere. ---\n")

try:
    # Avvia thread di ricezione
    t = threading.Thread(target=ricevi_messaggi, args=(client,), daemon=True)
    t.start()

    # Loop di invio messaggi
    while t.is_alive():
        msg = input("Tu: ").strip()
        if not msg:
            continue
        invia(client, msg)
        if msg.upper() == "FINE":
            print("[*] Hai chiuso la chat.")
            break

except KeyboardInterrupt:
    print("\n\n[!] Client interrotto (Ctrl+C)")
finally:
    # FASE 3: close()
    client.close()
    print("[3] Connessione Client chiusa\n")
