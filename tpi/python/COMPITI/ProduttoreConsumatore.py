# Skeleton programma generico thread multipli

import threading
import time

prelevato = threading.Semaphore(1) # Verde, il produttore può produrre subito
depositato = threading.Semaphore(0) # Rosso, il consumatore deve aspettare che il produttore produca
buffer = None
stop_event = threading.Event()

def produttore():
    global buffer
    contatore = 0
    while not stop_event.is_set():
        prelevato.acquire() # Il produttore aspetta che il consumatore prelevi 
        if stop_event.is_set():
            break
        contatore += 1
        buffer = f"Dato_{contatore}" # Il produttore produce un dato
        print("Prodotto:", buffer)
        time.sleep(1)
        depositato.release() # Il produttore segnala al consumatore che ha prodotto

def consumatore():
    global buffer
    dato = None
    while not stop_event.is_set():
        depositato.acquire() # Il consumatore aspetta che il produttore produca 
        if stop_event.is_set():
            break
        dato = buffer
        print("Consumato:", buffer) # Il consumatore consuma il dato
        prelevato.release() # Il consumatore segnala al produttore che ha prelevato  
        consuma(dato) 


def consuma(dato):
    del dato

if __name__ == "__main__":
    t1 = threading.Thread(target=produttore, daemon=True)
    t2 = threading.Thread(target=consumatore, daemon=True)
    t1.start()
    t2.start()
    
    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        print("\nFermo il programma...")
        stop_event.set()
        time.sleep(1)
        print("Programma terminato")
