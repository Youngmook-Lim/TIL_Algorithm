n = int(input())

def move(n, a, c, b):
    if n == 1:
        print(a, c)
        return

    move(n-1, a, b, c)
    print(a, c)
    move(n-1, b, c, a)

print(2**n-1)
move(n, 1, 3, 2)