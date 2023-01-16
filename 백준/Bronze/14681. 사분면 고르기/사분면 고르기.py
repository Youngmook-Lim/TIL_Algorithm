a = int(input())
b = int(input())

def quad(a,b):
    if a > 0 and b > 0:
        return print(1)
    elif a < 0 and b > 0:
        return print(2)
    elif a < 0 and b < 0:
        return print(3)
    elif a > 0 and b < 0:
        return print(4)

quad(a,b)