import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))


def find_sol(m, trees, start, end):
    if start > end:
        return end
    cut_tree = 0
    mid = (start+end) // 2

    for i in trees:
        if i >= mid:
            cut_tree += i - mid

    if cut_tree >= m:
        return find_sol(m, trees, mid + 1, end)
    else:
        return find_sol(m, trees, start, mid - 1)

print(find_sol(m, trees, 0, max(trees)))