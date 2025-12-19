import requests
import os

os.environ["HTTP_PROXY"] = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"
from datetime import datetime

# URL dati terremoti della settimana
url = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson"

response = requests.get(url)
data = response.json()

# Lista di terremoti con info principali
earthquakes = []
for feature in data["features"]:
    properties = feature["properties"]
    geometry = feature["geometry"]

    earthquake = {
        "place": properties["place"],
        "magnitude": properties["mag"],
        "time": datetime.utcfromtimestamp(properties["time"] / 1000),  # timestamp in secondi
        "depth": geometry["coordinates"][2],  # profondità in km
    }
    earthquakes.append(earthquake)

# Ordina i terremoti per magnitudo decrescente
earthquakes.sort(key=lambda x: x["magnitude"], reverse=True)

# Stampa professionale
print(f"{'Magnitudo':<10} {'Profondità(km)':<15} {'Data/Ora UTC':<20} {'Luogo'}")
print("-" * 70)
for eq in earthquakes[:10]:  # stampiamo i primi 10 più forti
    print(f"{eq['magnitude']:<10.1f} {eq['depth']:<15.1f} {eq['time']:<20} {eq['place']}")
