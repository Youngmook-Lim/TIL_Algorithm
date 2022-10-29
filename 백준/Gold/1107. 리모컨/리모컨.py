import sys

input = sys.stdin.readline

n = int(input())
m = int(input())

if m != 0:
    broken = list(map(int, input().split()))
else:
    broken = []

ans = abs(n - 100)

for i in range(1000000):
    for j in str(i):
        if int(j) in broken:
            break
    else:
        ans = min(ans, len(str(i)) + abs(i - n))

print(ans)