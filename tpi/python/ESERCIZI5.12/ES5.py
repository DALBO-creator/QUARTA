tentativi = 5
number = 100
guess = None
while tentativi > 0 and guess != number:
    guess = int(input("guess: "))
    tentativi -= 1
    if guess > number:
        print("troppo grande")
    elif guess < number:
        print("troppo piccolo")    
    elif guess == number:
        print("corretto")  
        break    
    