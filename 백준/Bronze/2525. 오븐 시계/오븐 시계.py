A, B = map(int, input().split(" "))
C = int(input())

if B + C < 60:
    print(A, B+C)
elif B + C >= 60:
    s = (B + C)//60
    if A + s < 24:
        print(A+s, B + C - 60 * s)
    elif A + s >= 24:
        print(A+s-24, B + C - 60 * s)