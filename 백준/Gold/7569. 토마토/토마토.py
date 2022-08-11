import sys
from collections import deque

input = sys.stdin.readline

m, n, h = map(int, input().split())

box = [[[0] * m for _ in range(n)] for _ in range(h)]

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

for i in range(h):
    for j in range(n):
        box[i][j] = list(map(int, input().split()))

arr = []
flag = 0

for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 1:
                arr.append([k, j, i])
            if box[i][j][k] not in [1, -1]:
                flag = 1

if flag == 0:
    print(0)
    quit()


def bfs():
    q = deque(arr)
    while q:
        x, y, z = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < m and 0 <= ny < n and 0 <= nz < h:
                if box[nz][ny][nx] == 0:
                    box[nz][ny][nx] = box[z][y][x] + 1
                    q.append([nx, ny, nz])

bfs()

ans = 0

for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 0:
                print(-1)
                quit()
            if box[i][j][k] > ans:
                ans = box[i][j][k]

print(ans - 1)