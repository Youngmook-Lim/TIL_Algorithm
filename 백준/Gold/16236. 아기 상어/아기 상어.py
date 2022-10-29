import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

pond = [list(map(int, input().split())) for _ in range(n)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

x, y, size = 0, 0, 2

for i in range(n):
    for j in range(n):
        if pond[i][j] == 9:
            x = j
            y = i
            break


def bfs(x, y, size):
    visited = [[0] * n for _ in range(n)]
    distance = [[0] * n for _ in range(n)]
    visited[y][x] = 1

    temp = []
    q = deque([[x, y, size]])
    while q:
        x, y, size = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < n and 0 <= ny < n) and visited[ny][nx] == 0:
                if pond[ny][nx] <= size:
                    distance[ny][nx] = distance[y][x] + 1
                    visited[ny][nx] = 1
                    q.append([nx, ny, size])
                    if pond[ny][nx] < size and pond[ny][nx] != 0:
                        temp.append((nx, ny, distance[ny][nx]))
    return sorted(temp, key=lambda x: (-x[2], -x[1], -x[0]))


secs = 0
eat = 0

while True:
    sharks = bfs(x, y, size)

    if not sharks:
        print(secs)
        break

    nx, ny, distance = sharks.pop()
    
    secs += distance
    pond[y][x], pond[ny][nx] = 0, 0

    x, y = nx, ny
    eat += 1

    if size == eat:
        size += 1
        eat = 0
