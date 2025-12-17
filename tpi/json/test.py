import json
import requests
import os

os.environ["HTTP_PROXY"] = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"

url = "https://raw.githubusercontent.com/fanzeyi/pokemon.json/master/pokedex.json"

response = requests.get(url)

dati = response.json() #converte il file .json in una struct Python e lo salva nella variabile "dati"
# print(dati[:3]) #stampa i primi 3 elementi

#join è un metodo delle stringhe che unisce stringhe separate da un carattere scelto

for pokemon in dati:
    nome = pokemon["name"]["english"]
    tipo = pokemon["type"]
    puntiSalute = pokemon["base"]["HP"]

    print(f"nome: {nome}")
    print(f"tipo/i: {', '.join(tipo)}")
    print(f"punti salute:  {puntiSalute}")

