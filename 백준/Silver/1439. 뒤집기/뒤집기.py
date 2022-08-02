import sys

input = sys.stdin.readline

s = input().strip()

zero = 0
one = 0

i = 0

while i < len(s):
    if s[i] == "0":
        for j in range(i, len(s)):
            if s[j] != s[i]:
                zero += 1
                i = j
                break
            elif j == len(s) - 1:
                zero += 1
                i = j + 1
                break

    elif s[i] == "1":
        for j in range(i, len(s)):
            if s[j] != s[i]:
                one += 1
                i = j
                break
            elif j == len(s) - 1:
                one += 1
                i = j + 1
                break

print(min(zero, one))
