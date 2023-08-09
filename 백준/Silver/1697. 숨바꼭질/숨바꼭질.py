from collections import deque

n, k = map(int, input().split())
MAX = 10 ** 5
arr = [0] * (MAX+1)

def bfs(n):
    q = deque([n])
    while q:
        x = q.popleft()
        if x == k:
            print(arr[x])
            return
        for i in [x - 1, x + 1, x * 2]:
            if 0 <= i <= MAX and not arr[i]:
                arr[i] = arr[x] + 1
                q.append(i)

bfs(n)
