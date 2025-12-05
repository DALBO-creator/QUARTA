# Programma di controllo accessi

# Chiediamo all'utente che tipo di account vuole usare
ruolo = input("Sei un amministratore o un utente normale? (admin/utente): ")

# Controlliamo se l'utente ha scritto "admin"
if ruolo == "admin":
    # Chiediamo la password dell'amministratore
    password = input("Inserisci la password amministratore: ")

    # Verifichiamo se è corretta
    if password == "admin123":
        print("Accesso amministratore consentito")
    else:
        print("Accesso negato")

# Controlliamo se l'utente ha scritto "utente"
elif ruolo == "utente":
    # Chiediamo la password utente
    password = input("Inserisci la password utente: ")

    # Verifichiamo se è corretta
    if password == "user123":
        print("Accesso utente consentito")
    else:
        print("Accesso negato")

# Se l'utente ha scritto qualcosa di diverso da admin/utente
else:
    print("Ruolo non riconosciuto")
