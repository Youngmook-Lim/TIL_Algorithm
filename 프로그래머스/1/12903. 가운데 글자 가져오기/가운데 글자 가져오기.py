def solution(s):
    a = len(s)
    if a % 2 == 0:
        return s[a//2 - 1: a//2 + 1]
    else:
        return s[a//2]