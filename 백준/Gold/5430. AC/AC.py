import sys
from collections import deque

input = sys.stdin.readline

T = int(input())


def sol():
    global p, arr
    flag = 0
    cnt = 0

    for i in range(len(p)):
        if p[i] == 'R':
            cnt += 1
        else:
            if len(arr) == 0:
                print('error')
                flag = 1
                break
            elif cnt % 2 == 0:
                arr.popleft()
            else:
                arr.pop()

    if not flag:
        if cnt % 2 == 0:
            print('[', ','.join([str(i) for i in arr]), ']', sep='')
        else:
            arr.reverse()
            print('[', ','.join([str(i) for i in arr]), ']', sep='')

        return


for _ in range(T):
    p = input().strip()
    n = int(input())
    arr = input().strip()
    arr = deque(list(map(int, arr[1:-1].split(',')))) if len(arr) > 2 else deque()
    sol()

