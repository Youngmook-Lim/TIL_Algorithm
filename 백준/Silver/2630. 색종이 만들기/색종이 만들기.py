import sys
input = sys.stdin.readline

n = int(input())

arr = [[] for _ in range(n)]
for i in range(n):
    arr[i] = list(map(int, input().split()))

cnt1 = 0
cnt0 = 0

def sol(xstart, xend, ystart, yend):
    global cnt1, cnt0
    temp = []
    for i in range(ystart, yend):
        for j in range(xstart, xend):
            temp.append(arr[i][j])
    if sum(temp) == len(temp):
        cnt1 += 1
        return
    elif sum(temp) == 0:
        cnt0 += 1
        return

    else:
        xmid = (xstart + xend) // 2
        ymid = (ystart + yend) // 2
        sol(xstart, xmid, ystart, ymid)
        sol(xmid, xend, ystart, ymid)
        sol(xstart, xmid, ymid, yend)
        sol(xmid, xend, ymid, yend)

sol(0, n, 0, n)
print(cnt0)
print(cnt1)
