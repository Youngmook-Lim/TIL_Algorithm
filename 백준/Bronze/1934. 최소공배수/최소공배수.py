import sys
input = sys.stdin.readline

t = int(input())

nums = []
for _ in range(t):
    nums.append(list(map(int, input().split())))

for i in nums:
    x = i[0]
    y = i[1]

    xx, yy = x, y

    while yy != 0:
        xx, yy = yy, xx % yy

    print(x * y // xx)