import socket

# Client Side
# TCP che si connette al server, partecipa al quiz e mostra il risultato finale.

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET     # IPv4
SOCKET_TYPE    = socket.SOCK_STREAM # TCP
SERVER_HOST    = '10.4.54.20'        # (da modificare) Indirizzo del server
SERVER_PORT    = 5000               # (da modificare) Porta del server

# ===== FUNZIONI DI COMUNICAZIONE =====
def invia(sock, testo):
    """Invia una stringa UTF-8 terminata da newline."""
    sock.sendall((testo + "\n").encode('utf-8'))

buffer = b""

def ricevi(sock):
    global buffer

    while b"\n" not in buffer:
        chunk = sock.recv(1024)
        if not chunk:
            return None
        buffer += chunk

    linea, buffer = buffer.split(b"\n", 1)
    return linea.decode("utf-8").strip()

# ===== AVVIO CLIENT =====
print("\n=== CLIENT TCP - Quiz Geografia ===")

# FASE 1: socket() - Crea socket
client = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
print("[1] Socket creato")

# FASE 2: connect() - Connessione al server (Three-way handshake)
client.connect((SERVER_HOST, SERVER_PORT))
print(f"[2] Connesso a {SERVER_HOST}:{SERVER_PORT}\n")

try:
    while True:

        # FASE 3: read/recv() - Riceve messaggio dal server (Client/Server Session)
        messaggio = ricevi(client)
        print(f"[3] Read: '{messaggio}'")

        # Segnale di fine quiz: esce dal ciclo
        if messaggio == "FINE":
            print("\n[*] Sessione terminata. Arrivederci!")
            break

        # Mostra il messaggio all'utente
        print(messaggio)

        # Se è una domanda (formato "[N/M] testo?") acquisisce la risposta
        if messaggio.startswith("["):

            # FASE 4: write/send() - Invia risposta dell'utente (Client/Server Session)
            risposta = input("La tua risposta: ").strip()
            invia(client, risposta)
            print(f"[4] Write: '{risposta}'")

finally:
    # FASE 5: close() - Chiude connessione
    client.close()
    print("[5] Connessione Client chiusa\n")
