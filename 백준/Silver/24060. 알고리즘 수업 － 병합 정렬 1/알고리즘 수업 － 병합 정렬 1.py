import sys
input = sys.stdin.readline

n, p = map(int, input().split())

arr = list(map(int, input().split()))[:n]
cnt = 0

def mergeSort(arr, l, r):
    if l < r:

        m = (l + r) // 2

        mergeSort(arr, l, m)
        mergeSort(arr, m+1, r)
        merge(arr, l, m, r)


def merge(arr, l, m, r):
    global cnt, p
    n1 = m - l + 1
    n2 = r - m

    L = [0] * n1
    R = [0] * n2

    for i in range(0, n1):
        L[i] = arr[l+i]
    for j in range(0, n2):
        R[j] = arr[m+1+j]

    i = 0
    j = 0
    k = l

    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
            cnt += 1
            if cnt == p:
                print(arr[k])
        else:
            arr[k] = R[j]
            j += 1
            cnt += 1
            if cnt == p:
                print(arr[k])
        k += 1

    while i < n1:
        arr[k] = L[i]
        cnt += 1
        if cnt == p:
            print(arr[k])
        i += 1
        k += 1

    while j < n2:
        arr[k] = R[j]
        cnt += 1
        if cnt == p:
            print(arr[k])
        j += 1
        k += 1


mergeSort(arr, 0, len(arr)-1)
if cnt < p:
    print(-1)