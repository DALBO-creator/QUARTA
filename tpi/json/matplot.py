import matplotlib.pyplot as plt
import requests
import os

os.environ["HTTP_PROXY"] = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"

url = "https://raw.githubusercontent.com/fanzeyi/pokemon.json/master/pokedex.json"

response = requests.get(url)

dati = response.json()
#grafico a barre numero pokemon - tipo
#conteggio tipi pokemon
conta_tipi = {}

for pokemon in dati:
    for tipo in pokemon["type"]:
        conta_tipi[tipo] = conta_tipi.get(tipo, 0) + 1

types= list(conta_tipi.keys())
counts= list(conta_tipi.values())

plt.figure(figsize=(10,6))
plt.bar(types, counts, color='pink')
plt.title("Numero di pokemon per tipo")
plt.xlabel("Tipo")
plt.ylabel("Numero di pokemon")
plt.xticks(rotation = 45, ha= 'right')
plt.grid(True)
plt.show()