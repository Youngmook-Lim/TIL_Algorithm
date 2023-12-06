def gcd(x, y):
    while y != 0:
        x, y = y, x%y
    return x

def solution(n, m):
    a = gcd(n, m)
    answer = [a, n * m // a]
    return answer