N = int(input())
arr = list(map(int, input()))

print(sum(arr[i] for i in range(N)))