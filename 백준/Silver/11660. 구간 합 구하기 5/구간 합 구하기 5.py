import sys

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]
ans = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        ans[i][j] = ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1] + graph[i - 1][j - 1]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())

    print(ans[x2][y2] - ans[x2][y1 - 1] - ans[x1 - 1][y2] + ans[x1 - 1][y1 - 1])
