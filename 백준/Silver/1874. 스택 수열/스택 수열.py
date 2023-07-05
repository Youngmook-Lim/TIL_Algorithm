import sys
input = sys.stdin.readline
n = int(input())

target = [int(input()) for _ in range(n)]
sol = []
symbols = []

flag = 0
arr = []
cnt = 1
index = 0

while True:
    if flag == 1:
        break

    if target[index] > cnt:
        arr.append(cnt)
        symbols.append('+')
        cnt += 1
    elif target[index] == cnt:
        arr.append(cnt)
        symbols.append('+')
        if cnt < n:
            cnt += 1
        sol.append(arr.pop())
        symbols.append('-')
        index += 1
    elif target[index] < cnt:
        sol.append(arr.pop())
        symbols.append('-')
        if sol[-1] == target[index]:
            index += 1
        else:
            flag = 1

    if len(sol) == len(target):
        break

if target == sol:
    for i in symbols:
        print(i)
else:
    print('NO')