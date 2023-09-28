n = int(input())

c, s = 100, 100
for _ in range(n):
    cc, ss = map(int, input().split())
    if cc > ss:
        s -= cc
    elif cc < ss:
        c -= ss

print(c)
print(s)
