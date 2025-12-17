def analizza_lista(lista):
    if not lista:
        return ("None", "None", "None")
    return [min(lista), max(lista), round(sum(lista) / len(lista), 2)]
