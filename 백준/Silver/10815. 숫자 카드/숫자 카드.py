import sys
input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))[:n]
arr.sort()

m = int(input())

check = list(map(int, input().split()))[:m]

ans = []
def bin(n, arr, start, end):
    if start > end:
        return 0

    mid = (start + end) // 2

    if arr[mid] == n:
        return 1
    elif arr[mid] > n:
        return bin(n, arr, start, mid - 1)
    elif arr[mid] < n:
        return bin(n, arr, mid + 1, end)


for i in check:
    ans.append(bin(i, arr, 0, n-1))

for i in ans:
    print(i, end=' ')