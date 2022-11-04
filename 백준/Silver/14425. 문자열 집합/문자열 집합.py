import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [input().strip() for _ in range(n)]
check = [input().strip() for _ in range(m)]

cnt = 0

for i in check:
    if i in arr:
        cnt += 1


print(cnt)