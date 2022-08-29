import sys

input = sys.stdin.readline

n, m = map(int, input().split())
list_n = list(map(int, input().split()))
list_n.sort()

temp = []


def sol():
    if len(temp) == m:
        print(*temp)
        return
    for i in range(n):
        if list_n[i] not in temp:
            temp.append(list_n[i])
            sol()
            temp.pop()


sol()
