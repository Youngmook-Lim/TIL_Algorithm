import sys
input = sys.stdin.readline
from collections import deque
n = int(input())

table = [list(map(int, input().strip())) for _ in range(n)]
sol = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
# print(*table, sep='\n')

def bfs(x, y):
    q = deque()
    q.append([x, y])
    table[y][x] = 0
    cnt = 1
    while q:
        x, y = q.popleft()
        # print(*table, sep='\n')
        # print()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and table[ny][nx] == 1:
                q.append([nx, ny])
                table[ny][nx] = 0
                cnt += 1
    sol.append(cnt)


for i in range(n):
    for j in range(n):
        if table[i][j] == 1:
            bfs(j, i)

# print(*table, sep='\n')

print(len(sol))
sol.sort()
for i in sol:
    print(i)


# for k in range(2, counter+1):
#     cnt = 0
#     for i in range(n):
#         for j in range(n):
#             if table[i][j] == k:
#                 cnt += 1
#     sol.append(cnt)
#
# sol.sort()
# for i in sol:
#     print(i)
