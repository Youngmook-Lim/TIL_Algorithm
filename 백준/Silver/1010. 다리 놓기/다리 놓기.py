import math

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())

    cnt = 0

    for i in range(m):
        rng = m - i - 1
        if rng >= n - 1:
            cnt += (math.factorial(rng) / (math.factorial(rng - (n-1)) * math.factorial(n-1)))

    print(int(cnt))