import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
table = [list(map(int, input().strip())) for _ in range(n)]

def bfs(x, y):
    q = deque([[x, y]])
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while q:
        x, y = q.popleft()
        if x == m-1 and y == n-1:
            return table[y][x]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and table[ny][nx] == 1:
                table[ny][nx] = table[y][x] + 1
                q.append([nx, ny])

print(bfs(0,0))