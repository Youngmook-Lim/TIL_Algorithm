import sys
input = sys.stdin.readline

m = int(input())
S = set()

for _ in range(m):
    a = input().strip().split()
    if len(a) != 1:
        cmd, num = a[0], a[1]
        num = int(num)

        if cmd == 'add':
            S.add(num)
        if cmd == 'remove':
            S.discard(num)
        if cmd == 'check':
            if num in S:
                print(1)
            else:
                print(0)
        if cmd == 'toggle':
            if num in S:
                S.discard(num)
            else:
                S.add(num)
    else:
        cmd = a[0]
        if cmd == 'all':
            S.clear()
            S = set([i for i in range(1, 21)])

        if cmd == 'empty':
            S = set()



