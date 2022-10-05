import sys
input = sys.stdin.readline

n = int(input())
arr = [0]
for _ in range(n):
    arr.append(int(input()))

dp = [0] * (n+1)

def sol(n):
    dp[1] = arr[1]
    if n == 1:
        return dp[1]
    dp[2] = arr[1] + arr[2]
    if n == 2:
        return dp[2]
    dp[3] = max(arr[2] + arr[3], arr[1] + arr[3])
    if n == 3:
        return dp[3]
    for i in range(4, n+1):
        dp[i] = arr[i] + max(dp[i-3] + arr[i-1], dp[i-2])
    return dp[-1]

print(sol(n))
