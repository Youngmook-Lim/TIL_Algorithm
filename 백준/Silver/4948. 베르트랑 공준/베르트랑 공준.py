from math import sqrt

arr = []

for i in range(2, 246913):
    for j in range(2, int(sqrt(i))+1):
        if i % j == 0:
          break
    else:
        arr.append(i)

while True:
    n = int(input())
    if n == 0:
        break
    count = 0
    for i in arr:
        if n < i <= 2 * n:
            count += 1

    print(count)