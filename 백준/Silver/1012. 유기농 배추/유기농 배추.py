import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    field = [[0 for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        i, j = map(int, input().split())
        field[j][i] = 1

    cnt = 0

    def rec(j, i):
        if field[j][i] == 0:
            return
        else:
            field[j][i] = 0
        if i > 0:
            rec(j, i - 1)
        if j > 0:
            rec(j - 1, i)
        if i < m - 1:
            rec(j, i + 1)
        if j < n - 1:
            rec(j + 1, i)



    for j in range(n):
        for i in range(m):
            if field[j][i] == 1:
                cnt += 1
                rec(j, i)
    print(cnt)


