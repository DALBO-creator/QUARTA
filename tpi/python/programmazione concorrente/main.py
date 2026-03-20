#Cinque filosofi, con stallo
 
import threading
 
N = 5
 
forchette = [threading.Semaphore(1) for _ in range(N)]
mutex = threading.Lock() #semaforo binario
# mutex = threading.Semaphore(1) #quivalente
 
def filosofo(id):
    sinistra = id
    destra = (id + 1) % N
    while True:
        mutex.acquire() 
        print(f"Filosofo {id} sta pensando")
        forchette[sinistra].acquire()
        forchette[destra].acquire()
        print(f"Filosofo {id} mangia")
        forchette[sinistra].release()
        forchette[destra].release()
        mutex.release() 
 
def main():
    filosofi = [threading.Thread(target=filosofo, args=(i,)) for i in range(N)]
    for f in filosofi:
        f.start()

    for f in filosofi:
        f.join()    
 
 

if __name__ == "__main__":
    main()

 
 
