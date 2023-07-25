import sys

input = sys.stdin.readline

n = int(input())

arr = []

for _ in range(n):
    a, b = map(int, input().split())
    arr.append([a, b])

arr.sort(key=lambda x: (x[1], x[0]))

cnt = 1
last = arr[0][1]

for j in range(1, len(arr)):
    if arr[j][0] >= last:
        cnt += 1
        last = arr[j][1]

print(cnt)