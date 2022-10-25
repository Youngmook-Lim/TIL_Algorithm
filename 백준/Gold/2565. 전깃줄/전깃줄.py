import sys
input = sys.stdin.readline

n = int(input())

temp_arr = []

for _ in range(n):
    temp_arr.append(list(map(int, input().split())))

temp_arr.sort(key= lambda x: x[0])

arr = []

for i in range(n):
    arr.append(temp_arr[i][1])

dp = [1] * n

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))