n = int(input())
table = [list(map(int, input())) for _ in range(n)]

def rec(table, xstart, ystart, n):
    global sol

    total = 0
    for i in range(ystart, ystart+n):
        for j in range(xstart, xstart+n):
            total += table[i][j]

    if total == 0:
        sol = sol + '0'
        return
    elif total == n ** 2:
        sol = sol + '1'
        return
    else:
        n = n // 2
        sol = sol + '('
        rec(table, xstart, ystart, n)
        rec(table, xstart + n, ystart, n)
        rec(table, xstart, ystart+n, n)
        rec(table, xstart+n, ystart+n, n)
        sol = sol + ')'

sol = ''

rec(table, 0, 0, n)

print(sol)