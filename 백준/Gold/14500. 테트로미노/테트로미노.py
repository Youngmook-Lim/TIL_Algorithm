import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
max_val = max(map(max, board))


maxi = 0

def dfs(i, j, total, cnt):
    global maxi
    
    if maxi >= total + max_val * (4 - cnt):
        return

    if cnt == 4:
        maxi = max(maxi, total)
        return

    for k in range(4):
        ni = i + move[k][0]
        nj = j + move[k][1]
        if 0 <= ni < n and 0 <= nj < m and not visited[ni][nj]:
            if cnt == 2:
                visited[ni][nj] = 1
                dfs(i, j, total + board[ni][nj], cnt + 1)
                visited[ni][nj] = 0
            visited[ni][nj] = 1
            dfs(ni, nj, total + board[ni][nj], cnt + 1)
            visited[ni][nj] = 0


for i in range(n):
    for j in range(m):
        visited[i][j] = 1
        dfs(i, j, board[i][j], 1)
        visited[i][j] = 0


print(maxi)

