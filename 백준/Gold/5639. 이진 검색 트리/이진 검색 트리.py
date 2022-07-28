import sys

sys.setrecursionlimit(10 ** 6)

tree = []

while True:
    try:
        tree.append(int(input()))
    except:
        break

length = len(tree)


def sol(start, end):
    if start > end:
        return

    mid = end + 1
    for i in range(start + 1, end + 1):
        if tree[start] < tree[i]:
            mid = i
            break

    sol(start + 1, mid - 1)
    sol(mid, end)
    print(tree[start])


sol(0, length - 1)