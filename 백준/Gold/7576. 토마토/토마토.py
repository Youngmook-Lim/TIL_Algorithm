import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    q = deque(arr)
    while q:
        x = q.popleft()
        ni = [1, -1, 0, 0]
        nj = [0, 0, 1, -1]
        temp = []
        for k in range(4):
            newi, newj = x[0] + ni[k], x[1] + nj[k]
            if 0 <= newi < n and 0 <= newj < m and tomato[newi][newj] == 0:
                tomato[newi][newj] = tomato[x[0]][x[1]] + 1
                q.append([newi, newj])

m, n = map(int, input().split())

tomato = [list(map(int, input().split())) for _ in range(n)]

arr = []
for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            arr.append([i, j])

bfs()

sol = 0
flag = 0

for i in tomato:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    sol = max(sol, max(i))

print(sol-1)