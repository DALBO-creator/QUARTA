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

# for pokemon in dati:
#     nome = pokemon["name"]["english"]
#     tipo = pokemon["type"]
#     puntiSalute = pokemon["base"]["HP"]

#     print(f"nome: {nome}")
#     print(f"tipo/i: {', '.join(tipo)}")
#     print(f"punti salute:  {puntiSalute}")

#******************************************************************

# specifico_pokemon = None

# for pokemon in dati:
#     if pokemon['id'] == 25:
#         specifico_pokemon = pokemon
#         break

# if specifico_pokemon:
#     print("pokemon trovato: ", specifico_pokemon)
# else:
#     print("pokemon non trovato")    

#******************************************************************    
def get_name(pokemon):
    return pokemon['name']['english']
#ritorna nome in inglese del pokemon
#sorted() è una funzione built-in di Python
#prende una lista (dati)
#la ordina
#restituiscie una nuova lista ordinata, senza modificare l'originale

sorted_by_name = sorted(dati, key=get_name)

for pokemon in sorted_by_name:
    print(f"ID: {pokemon['id']}, Nome: {get_name(pokemon)} ")