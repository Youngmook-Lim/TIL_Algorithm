arr = []

for _ in range(5):
    arr.append(int(input()))

for i in range(len(arr)):
    if arr[i] < 40:
        arr[i] = 40

print(int(sum(arr) / 5))