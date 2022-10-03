import sys

input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    cmd = input().strip()
    if 'push_front' in cmd:
        arr.insert(0, cmd[11:])
    elif 'push_back' in cmd:
        arr.append(cmd[10:])
    elif cmd == 'pop_front':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop(0))
    elif cmd == 'pop_back':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop(-1))
    elif cmd == 'size':
        print(len(arr))
    elif cmd == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif cmd == 'front':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[0])
    elif cmd == 'back':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])