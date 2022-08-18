N = int(input())
arr = []
for i in range(N):
    arr.append(list(input()))
for j in arr:
    sum = 0
    c = 1
    for i in j:
        if i == "O":
            sum += c
            c += 1
        else:
            c = 1
    print(sum)