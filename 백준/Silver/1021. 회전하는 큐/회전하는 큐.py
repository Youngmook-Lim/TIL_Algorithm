import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
q = deque()
ans = 0

for i in range(1, n + 1):
    q.append(i)

arr = list(map(int, input().split()))

for num in arr:
    half = n // 2
    idx = q.index(num)
    if idx <= half:
        ans += idx
        for i in range(idx):
            q.append(q.popleft())
    else:
        ans += n - idx
        for i in range(n - idx):
            q.appendleft(q.pop())
    q.popleft()
    n -= 1

print(ans)
