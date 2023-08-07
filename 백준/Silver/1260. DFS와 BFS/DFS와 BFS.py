from collections import deque

n, m, v = map(int, input().split())

arr = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

for i in range(n+1):
    arr[i].sort()

dfs_res = []
bfs_res = []

def dfs(start):
    dfs_res.append(start)
    visited[start] = 1
    for i in arr[start]:
        if not visited[i]:
            dfs(i)
dfs(v)

visited = [0] * (n+1)

def bfs(start):
    bfs_res.append(start)
    q = deque([start])
    visited[start] = 1
    while q:
        x = q.popleft()
        for i in arr[x]:
            if not visited[i]:
                bfs_res.append(i)
                q.append(i)
                visited[i] = 1

bfs(v)

print(*dfs_res, sep=' ')
print(*bfs_res, sep=' ')
