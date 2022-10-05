import sys

input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

graph_new = [[0] * 3 for _ in range(n)]

for i in range(3):
    graph_new[0][i] = graph[0][i]

for i in range(1, n):
    for j in range(3):
        if j == 0:
            graph_new[i][j] = graph[i][j] + max(graph_new[i - 1][j], graph_new[i - 1][j + 1])
        elif j == 1:
            graph_new[i][j] = graph[i][j] + max(graph_new[i - 1][j - 1], graph_new[i - 1][j], graph_new[i - 1][j + 1])
        else:
            graph_new[i][j] = graph[i][j] + max(graph_new[i - 1][j], graph_new[i - 1][j - 1])

maxi = max(graph_new[n - 1])

for i in range(1, n):
    for j in range(3):
        if j == 0:
            graph[i][j] += + min(graph[i - 1][j], graph[i - 1][j + 1])
        elif j == 1:
            graph[i][j] += + min(graph[i - 1][j - 1], graph[i - 1][j], graph[i - 1][j + 1])
        else:
            graph[i][j] += + min(graph[i - 1][j], graph[i - 1][j - 1])

mini = min(graph[n - 1])
print(maxi, mini)
