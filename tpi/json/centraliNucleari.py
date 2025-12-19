import requests
import matplotlib.pyplot as plt
import folium

URL = "https://raw.githubusercontent.com/cristianst85/GeoNuclearData/master/data/json/denormalized/nuclear_power_plants.json"
dati = requests.get(URL).json()

# Stampa nomi reattori
print("NOMI DI TUTTI I REATTORI:")
for r in dati:
    print(r["Name"])

# reattori operativi
operativi = [r for r in dati if r["Status"] == "Operational"]
print("\nREATTORI OPERATIVI:")
for r in operativi:
    print(r["Name"])

# Statistiche
totale = len(dati)
num_operativi = len(operativi)
percentuale = (num_operativi / totale) * 100
print(f"\nReattori operativi: {num_operativi}/{totale}")
print(f"Percentuale: {percentuale:.2f}%")

# Conteggio per stato, uso counter per comodità (funzionamento cercato su internet..)
from collections import Counter
conteggio_stato = Counter(r["Status"] for r in dati)
print("\nNUMERO DI REATTORI PER STATO:")
for stato, conteggio in conteggio_stato.items():
    print(f"{stato}: {conteggio}")

# matplot
plt.bar(conteggio_stato.keys(), conteggio_stato.values())
plt.xlabel("Stato")
plt.ylabel("Numero reattori")
plt.title("Numero di reattori per stato")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# mappa
mappa = folium.Map(location=[20, 0], zoom_start=2)
for r in operativi:
    lat, lon = r.get("Latitude"), r.get("Longitude")
    if lat and lon:
        folium.Marker(
            location=[lat, lon],
            popup=f"<b>{r['Name']}</b><br>Paese: {r.get('Country', 'N/A')}<br>Potenza: {r.get('Capacity', 'N/A')} MW",
            icon=folium.Icon(color="green", icon="bolt")
        ).add_to(mappa)
mappa.save("centrali_nucleari_operativi.html")
print("Mappa salvata: centrali_nucleari_operativi.html")

# Istogramma potenza
potenze = [r["Capacity"] for r in dati if r.get("Capacity")]
plt.hist(potenze, bins=20, color='skyblue', edgecolor='black')
plt.xlabel("Potenza (MW)")
plt.ylabel("Numero reattori")
plt.title("Distribuzione della potenza dei reattori")
plt.tight_layout()
plt.show()
