import threading
import time
import random


def filosofo(i, N, mutex, posate, pasti):
    while True:
        print(f"Filosofo {i} pensa")
        time.sleep(random.uniform(0.5, 1.5))

        mutex.acquire()
        if posate[i] and posate[(i + 1) % N] and pasti[i] <= min(pasti):
            posate[i] = False
            posate[(i + 1) % N] = False
            mutex.release()
        else:
            mutex.release()
            continue

        print(f"Filosofo {i} mangia")
        time.sleep(1)

        mutex.acquire()
        posate[i] = True
        posate[(i + 1) % N] = True
        pasti[i] += 1
        mutex.release()


def main():
    N = 5  

    mutex = threading.Semaphore(1)
    posate = [True] * N
    pasti = [0] * N

    threads = []
    for i in range(N):
        t = threading.Thread(target=filosofo, args=(i, N, mutex, posate, pasti))
        t.daemon = True
        threads.append(t)
        t.start()

    time.sleep(10)

    print("\nRISULTATI:")
    for i in range(N):
        print(f"Filosofo {i} ha mangiato {pasti[i]} volte")


if __name__ == "__main__":
    main()