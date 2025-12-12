def analisiLista(lista):
    minimo = min(lista)
    massimo = max(lista)
    somma = sum(lista)
    media = sum(lista) / len(lista)

    return (minimo,massimo,somma,media)
