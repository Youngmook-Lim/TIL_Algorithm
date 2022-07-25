from collections import deque
import sys

board = [list(map(int, input().split())) for _ in range(19)]

dx = [1, 0, 1, 1]
dy = [0, 1, 1, -1]


def sol(x, y, s):
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        cnt = 1

        while 0 <= nx < 19 and 0 <= ny < 19 and board[ny][nx] == s:
            cnt += 1
            if cnt == 5:
                if 0 <= nx + dx[k] < 19 and 0 <= ny + dy[k] < 19 and board[ny + dy[k]][nx + dx[k]] == s:
                    break
                if 0 <= x - dx[k] < 19 and 0 <= y - dy[k] < 19 and board[y - dy[k]][x - dx[k]] == s:
                    break
                print(s)
                print(y + 1, x + 1)
                sys.exit(0)

            ny += dy[k]
            nx += dx[k]


for i in range(19):
    for j in range(19):
        if board[i][j] != 0:
            sol(j, i, board[i][j])

print(0)
