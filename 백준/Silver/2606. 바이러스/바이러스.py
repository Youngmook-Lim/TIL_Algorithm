import sys
input = sys.stdin.readline


n = int(input())

m = int(input())
arr = []
for _ in range(m):
    arr.append(list(map(int, input().split())))

sol = set()
test = [1]
temp = []

while True:
    cnt = 0
    for j in test:
        for i in range(len(arr)):
            if j in arr[i]:
                if arr[i][0] == j:
                    sol.add(arr[i][1])
                    temp.append(arr[i][1])
                    cnt += 1
                else:
                    sol.add(arr[i][0])
                    temp.append(arr[i][0])
                    cnt += 1

                arr[i] = [0, 0]

    if cnt == 0:
        break
    test = temp
    temp = []

print(len(sol))