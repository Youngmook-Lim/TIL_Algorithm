from collections import deque

n, m = map(int, input().split())
board = [0] * 101
visited = [0] * 101
arr = []


for _ in range(n):
    x, y = map(int, input().split())
    arr.append([x, y])

for _ in range(m):
    u, v = map(int, input().split())
    arr.append([u, v])

def bfs():
    q = deque([])
    q.append(1)
    while q:
        x = q.popleft()

        for i in arr:
            if x == i[0]:
                board[i[1]] = board[x]
                x = i[1]

        for i in range(1, 7):
            a = x + i
            if a <= 100:
                if visited[a] == 0:
                    board[a] = board[x] + 1
                    visited[a] = 1
                    if a == 100:
                        print(board[a])
                        return
                    q.append(a)

bfs()