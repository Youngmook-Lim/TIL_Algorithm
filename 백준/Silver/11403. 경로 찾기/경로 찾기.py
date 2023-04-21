n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

visited = [0] * n

def dfs(y, x):
    visited[x] = 1
    for i in range(n):
        if graph[x][i] == 1 and visited[i] == 0:
            dfs(x, i)


for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and visited[j] == 0:
            dfs(i, j)
    print(*visited)
    visited = [0] * n