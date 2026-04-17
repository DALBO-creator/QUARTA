import socket

# Server Side
# TCP iterativo che gestisce un quiz di Geografia con un client alla volta.

# ===== CONFIGURAZIONE =====
ADDRESS_FAMILY = socket.AF_INET     # IPv4
SOCKET_TYPE    = socket.SOCK_STREAM # TCP
SERVER_HOST    = '10.4.54.20'        # Indirizzo di ascolto
SERVER_PORT    = 5000               # Porta di ascolto

# ===== DATABASE DOMANDE (argomento: Geografia) =====
domande = [
    {"domanda": "Qual è la capitale della Francia?",         "risposta": "parigi"},
    {"domanda": "Qual è il fiume più lungo del mondo?",       "risposta": "nilo"},
    {"domanda": "In quale continente si trova il Brasile?",   "risposta": "america del sud"},
    {"domanda": "Qual è l'oceano più grande del mondo?",      "risposta": "pacifico"},
    {"domanda": "Quanti sono i continenti della Terra?",      "risposta": "7"},
    {"domanda": "Qual è la montagna più alta del mondo?",     "risposta": "everest"},
    {"domanda": "Quale paese ha la superficie più grande?",   "risposta": "russia"},
    {"domanda": "Qual è la capitale dell'Australia?",         "risposta": "canberra"},
    {"domanda": "In quale paese si trova il Machu Picchu?",   "risposta": "peru"},
    {"domanda": "Qual è il deserto più grande del mondo?",    "risposta": "sahara"},
]

# ===== FUNZIONI DI COMUNICAZIONE =====
def invia(sock, testo):
    """Invia una stringa UTF-8 terminata da newline."""
    sock.sendall((testo + "\n").encode('utf-8'))

def ricevi(sock):
    """Riceve dati fino al newline e restituisce la stringa pulita."""
    dati = b""
    while not dati.endswith(b"\n"):
        chunk = sock.recv(1024)
        if not chunk:
            break
        dati += chunk
    return dati.decode('utf-8').strip()

# ===== AVVIO SERVER =====
print("\n=== SERVER TCP - Quiz Geografia ===")

# FASE 1: socket() - Crea socket (Open Listen)
server = socket.socket(ADDRESS_FAMILY, SOCKET_TYPE)
print("[1] Socket creato")

# FASE 2: bind() - Associa socket a (IP, porta) (Open Listen)
server.bind(("0.0.0.0", SERVER_PORT))
print(f"[2] Bind su {SERVER_HOST}:{SERVER_PORT}")

# FASE 3: listen() - Mette in ascolto (Open Listen)
server.listen(20)   # backlog = 20 connessioni in coda
print("[3] Server in ascolto...")

try:
    while True:     # Server iterativo (un client alla volta)

        # FASE 4: accept() - Accetta connessione (Connection Request completato)
        client_socket, client_address = server.accept()
        print(f"\n[4] Accept: connessione da {client_address}")

        # ── Benvenuto ─────────────────────────────────────────────────────────
        invia(client_socket, "Benvenuto al Quiz di Geografia!")
        invia(client_socket, f"Risponderai a {len(domande)} domande. Buona fortuna!")

        punteggio = 0

        for i, item in enumerate(domande, start=1):

            # FASE 5: write/send() - Invia domanda (Client/Server Session)
            invia(client_socket, f"[{i}/{len(domande)}] {item['domanda']}")
            print(f"[5] Domanda {i} inviata")

            # FASE 6: read/recv() - Riceve risposta del client (Client/Server Session)
            risposta_client = ricevi(client_socket).lower().strip()
            print(f"[6] Read: '{risposta_client}'")

            # ── Valutazione ───────────────────────────────────────────────────
            if risposta_client == item['risposta']:
                punteggio += 1
                feedback = f"Corretto! Punteggio: {punteggio}"
            else:
                feedback = f"Sbagliato. Risposta corretta: {item['risposta'].capitalize()}"

            # FASE 7: write/send() - Invia feedback (Client/Server Session)
            invia(client_socket, feedback)
            print(f"[7] Feedback inviato: '{feedback}'")

        # ── Risultato finale ──────────────────────────────────────────────────
        percentuale = round(punteggio / len(domande) * 100 )
        invia(client_socket, "\n--- QUIZ TERMINATO ---")
        invia(client_socket, f"Punteggio finale: {punteggio}/{len(domande)} ({percentuale}%)")

        if   percentuale == 100: invia(client_socket, "Perfetto! Sei un esperto di geografia!")
        elif percentuale >= 70:  invia(client_socket, "Ottimo risultato!")
        elif percentuale >= 40:  invia(client_socket, "Buono, ma puoi migliorare.")
        else:                    invia(client_socket, "Studia ancora un po'... ci riuscirai!")

        invia(client_socket, "FINE")    # segnale di chiusura per il client
        print(f"[*] Punteggio finale: {punteggio}/{len(domande)}")

        # FASE 8: close() - Chiude connessione client (End Of File)
        client_socket.close()
        print(f"[8] Connessione con {client_address} chiusa")

except KeyboardInterrupt:
    print("\n\n[!] Server interrotto (Ctrl+C)")
finally:
    # FASE 9: close() - Chiude socket server
    server.close()
    print("[9] Socket server chiusa\n")
