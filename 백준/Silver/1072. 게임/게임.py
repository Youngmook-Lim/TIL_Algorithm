import sys, math

input = sys.stdin.readline

x, y = map(int, input().split())

z = math.floor(y * 100 / x)
# print(z)

find = 0


def bin_search(start, end):
    global find
    if start > end:
        return

    mid = (start + end) // 2

    a = math.floor((mid - x + y) * 100 / mid)
    a_2 = math.floor((mid - x + y + 1) * 100 / (mid + 1))
    # print(mid, start, end, a, a_2, z)
    # print(mid - x)

    if a == z and a_2 > z:
        print(mid - x + 1)
        find = 1
        return
    elif a > z:
        return bin_search(start, mid - 1)
    else:
        return bin_search(mid + 1, end)


bin_search(x, 20 ** 9)

if not find:
    print(-1)
