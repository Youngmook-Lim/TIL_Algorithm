import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
nodes = [[] for _ in range(n + 1)]

for i in range(n - 1):
    x, y = map(int, input().split())
    nodes[x].append(y)
    nodes[y].append(x)

visited = [0] * (n + 1)


def dfs(start):
    for i in nodes[start]:
        if visited[i] == 0:
            visited[i] = start
            dfs(i)


dfs(1)

for i in range(2, n + 1):
    print(visited[i])
