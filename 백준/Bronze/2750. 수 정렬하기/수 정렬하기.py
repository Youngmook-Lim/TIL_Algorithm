n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr_sort = sorted(arr)

for i in arr_sort:
    print(i)