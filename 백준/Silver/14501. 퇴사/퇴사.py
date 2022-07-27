n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

dp = [0] * n
if arr[0][0] == 1:
    dp[0] = arr[0][1]

for i in range(n):
    if i + arr[i][0] - 1 < n:
        if i == 0:
            dp[i + arr[i][0] - 1] = arr[i][1]
            x = i + arr[i][0]
            while x < n:
                dp[x] = arr[i][1]
                x += 1
        else:
            dp[i + arr[i][0] - 1] = max(dp[i + arr[i][0] - 1], dp[i - 1] + arr[i][1])
            x = i + arr[i][0]
            while x < n:
                dp[x] = max(dp[i + arr[i][0] - 1], dp[x])
                x += 1

print(max(dp))
