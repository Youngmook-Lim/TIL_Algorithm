import sys

input = sys.stdin.readline

n, m = map(int, input().split())

temp = []


def sol(start):
    if len(temp) == m:
        print(*temp)
        return
    for i in range(start, n + 1):
        temp.append(i)
        sol(i)
        temp.pop()

sol(1)
