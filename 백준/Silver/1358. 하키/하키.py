import math

w, h, x, y, p = map(int, input().split())

r = h // 2


cnt = 0
arr = []

for _ in range(p):
    arr.append(list(map(int, input().split())))

for i, j in arr:
    if x <= i <= x + w and y <= j <= y + h:
        cnt += 1
    elif i < x:
        dis = math.sqrt((x - i) ** 2 + (j - (y + r)) ** 2)
        if dis <= r:
            cnt += 1
    elif i > x + w:
        dis = math.sqrt((i - (x + w)) ** 2 + (j - (y + r)) ** 2)
        if dis <= r:
            cnt += 1

print(cnt)