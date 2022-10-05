n = int(input())

dp = [0] * 1001

for i in range(1, n+1):
    if i < 4:
        dp[i] = i
    else:
        dp[i] = dp[i-1] + dp[i-2]

print(dp[n] % 10007)