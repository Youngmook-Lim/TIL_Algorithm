import sys
input = sys.stdin.readline
n = int(input())

arr = []
ans = []
for _ in range(n):
    arr.append(input().strip())

for i in range(len(arr[0])):
    total = 0
    for j in range(len(arr)):
        if arr[j][i] == arr[0][i]:
            total += 1
    if total == len(arr):
        ans.append(arr[0][i])
    else:
        ans.append('?')

print(''.join(ans))