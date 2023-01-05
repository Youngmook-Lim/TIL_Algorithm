N = int(input())
count = 0
arr = []

for i in range(N):
    a = input()
    for j in range(len(a)):
        if a[j] not in arr:
            arr.append(a[j])
        elif a[j] == a[j-1]:
            arr.append(a[j])
    if len(arr) == len(a):
        count += 1
    arr = []

print(count)