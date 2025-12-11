def sommaVendite(merendineVendute):
    return sum(merendineVendute)

def indiceOraMax(merendineVendute):
    return merendineVendute.index(max(merendineVendute))

def oreSottoSoglia(merendineVendute, soglia):
    count = 0
    for x in merendineVendute:
        if x < soglia:
            count += 1
    return count

oraIniziale = int(input("Inserisci l'ora iniziale (0-23): "))

merendineVendute = []


for i in range(oraIniziale, oraIniziale + 6):
    merendine = -1
    while merendine < 0:
        merendine = int(input(f"Merendine vendute all'ora {i}: "))
        if merendine < 0:
            print("Errore: il numero di merendine vendute non può essere negativo. Riprova.")
    merendineVendute.append(merendine)

for i in range(len(merendineVendute)):
    print(f"All'ora {oraIniziale + i} sono state vendute {merendineVendute[i]} merendine.")

print(f"Totale merendine vendute: {sommaVendite(merendineVendute)}")


indice_max = indiceOraMax(merendineVendute)
print(f"L'ora con più vendite è: ora {oraIniziale + indice_max}")


soglia = int(input("Inserisci una soglia: "))
print(f"Ore con vendite sotto soglia: {oreSottoSoglia(merendineVendute, soglia)}")
