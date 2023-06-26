n = int(input())
arr = list(map(int, input().split()))[:n]

arr.sort()

if n % 2 == 0:
    print(arr[0] * arr[-1])
else:
    print(arr[n//2] ** 2)