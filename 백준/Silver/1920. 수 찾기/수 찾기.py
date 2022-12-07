import sys
input = sys.stdin.readline
n = int(input())
arr_n = sorted(list(map(int, input().split()))[:n])


m = int(input())
arr_m = list(map(int, input().split()))[:m]

def bin_search(target, arr, start, end):

    if start > end:
        print('0')
        return
    mid = (start + end) // 2

    if target == arr[mid]:
        print('1')
        return
    elif target > arr[mid]:
        return bin_search(target, arr, mid + 1, end)
    elif target < arr[mid]:
        return bin_search(target, arr, start, mid - 1)

for i in arr_m:
    bin_search(i, arr_n, 0, len(arr_n)-1)