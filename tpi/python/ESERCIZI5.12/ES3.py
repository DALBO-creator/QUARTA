def nPrimi (lista):
    def isPrimo(n):
        if n < 2:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True
    primi = []
    for n in lista:
        if isPrimo(n):
            primi.append(n)
    return primi       
    
print(nPrimi(range(1,14)))           

        