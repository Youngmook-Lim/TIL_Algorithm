import sys
input = sys.stdin.readline
n = int(input())

arr = []

for _ in range(n):
    cmd = input().strip()
    if 'push' in cmd:
        arr.append(int(cmd[5:]))

    elif cmd == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
            arr.pop(-1)

    elif cmd == 'size':
        print(len(arr))

    elif cmd == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)

    elif cmd == 'top':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])

