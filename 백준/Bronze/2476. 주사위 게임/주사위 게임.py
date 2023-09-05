n = int(input())

arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))

solution = []
for i in range(len(arr)):
    if arr[i][0] == arr[i][1] == arr[i][2]:
        solution.append(10000 + arr[i][0] * 1000)
    elif arr[i][0] == arr[i][1]:
        solution.append(1000 + arr[i][0] * 100)
    elif arr[i][1] == arr[i][2]:
        solution.append(1000 + arr[i][1] * 100)
    elif arr[i][2] == arr[i][0]:
        solution.append(1000 + arr[i][2] * 100)
    else:
        solution.append(max(arr[i]) * 100)

solution.sort()
print(solution[-1])