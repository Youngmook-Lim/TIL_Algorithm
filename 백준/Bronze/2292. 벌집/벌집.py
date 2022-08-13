N = int(input())

cnt = 1
i = 1

while i < N:
    i += 6 * cnt
    cnt += 1
print(cnt)
