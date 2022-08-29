import sys

input = sys.stdin.readline

n, m = map(int, input().split())
list_n = list(map(int, input().split()))
list_n.sort()

temp = []


def sol(start):
    if len(temp) == m:
        print(*temp)
        return
    for i in range(start, n):
        temp.append(list_n[i])
        sol(i)
        temp.pop()


sol(0)
