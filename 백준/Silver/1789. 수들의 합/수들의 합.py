s = int(input())

sum = 0
n = 1
while sum < s:
    if sum +2 * n + 1 <= s:
        sum += n
        n += 1
    elif sum + 2 * n + 1 > s:
        break

print(n)