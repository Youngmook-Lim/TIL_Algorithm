import sys

input = sys.stdin.readline
k, n = map(int, input().split())

arr = []
for _ in range(k):
    arr.append(int(input()))


def find_ans(target, arr, start, end):
    mid = (start + end) // 2
    if start > end:
        return mid

    num = sum([i // mid for i in arr])

    if num < target:
        return find_ans(target, arr, start, mid - 1)

    elif num >= target:
        return find_ans(target, arr, mid + 1, end)

print(find_ans(n, arr, 1, max(arr)))