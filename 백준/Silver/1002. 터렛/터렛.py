t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    r = (abs(x1 - x2)**2 + abs(y1-y2)**2)**0.5

    if r == 0 and r1 == r2:
        print(-1)
    else:
        if r == r1 + r2 or r == abs(r1-r2):
            print(1)
        elif abs(r1-r2) < r < r1 + r2:
            print(2)
        else:
            print(0)