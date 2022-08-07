import sys

input = sys.stdin.readline

n = int(input())
total = 0
col = [0] * n


def check(x):
    for i in range(x):
        if col[x] == col[i] or abs(col[x] - col[i]) == x - i:
            return False
    return True


def dfs(x):
    global total
    if x == n:
        total += 1
        return
    for i in range(n):
        col[x] = i
        if check(x):
            dfs(x + 1)


dfs(0)
print(total)
