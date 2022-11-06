import sys
from collections import deque

input = sys.stdin.readline

a, b = map(int, input().split())
flag = 0


def bfs(n, cnt):
    global flag
    q = deque()
    q.append([n, cnt])
    while q:
        n, cnt = q.popleft()
        if n == b:
            flag = 1
            print(cnt)
            break
        n1 = n * 2
        n2 = int(str(n) + '1')
        if n1 <= b:
            q.append([n1, cnt + 1])
        if n2 <= b:
            q.append([n2, cnt + 1])


bfs(a, 1)

if flag == 0:
    print(-1)
