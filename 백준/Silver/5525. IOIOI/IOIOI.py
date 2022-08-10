import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().strip()
length = n * 2 + 1

i = 0
cnt = 0
ans = 0

while i < (m-1):
    if s[i:i+3] == "IOI":
        cnt += 1
        i += 2
        if cnt == n:
            ans += 1
            cnt -= 1
    else:
        cnt = 0
        i += 1


print(ans)