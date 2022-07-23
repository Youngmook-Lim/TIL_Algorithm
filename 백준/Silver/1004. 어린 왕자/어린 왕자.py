import math

T = int(input())

for _ in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))

    cnt = 0

    for cx, cy, r in arr:
        dist1 = math.sqrt((cx - x1) ** 2 + (cy - y1) ** 2)
        dist2 = math.sqrt((cx - x2) ** 2 + (cy - y2) ** 2)
        if dist1 < r and dist2 < r:
            continue
        else:
            if dist1 <= r:
                cnt += 1
            if dist2 <= r:
                cnt += 1

    print(cnt)