n = int(input())
cnt = 0
while n > 0:
    if n % 5 == 0:
        n -= 5
        cnt += 1
    elif n % 3 == 0:
        n -= 3
        cnt += 1
    else:
        n -= 5
        cnt += 1

if n == 0:
    print(cnt)
else:
    print(-1)