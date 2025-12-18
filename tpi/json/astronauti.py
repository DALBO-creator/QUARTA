import requests

url = "http://api.open-notify.org/astros.json"

response = requests.get(url)
data = response.json()

print(" Astronauti attualmente nello spazio \n")
for astronaut in data["people"]:
    name = astronaut["name"]
    craft = astronaut["craft"]

   
    

    print(f"Nome: {name}")
    print(f"Stazione spaziale: {craft}")
    print("-" * 40)

# Statistiche finali
total = data["number"]
print(f"\nTotale astronauti nello spazio: {total}")
