import sys
input = sys.stdin.readline

n, k = map(int, input().split())

arr = []

for _ in range(n):
    arr.append(int(input()))

greedy = 0

for i in range(n):
    if arr[i] > k:
        greedy = i-1
        break
    if i == n-1:
        greedy = i

cnt = 0
while k > 0:
    if k >= arr[greedy]:
        temp = k // arr[greedy]
        k = k - temp * arr[greedy]
        cnt += temp
    else:
        greedy -= 1

print(cnt)