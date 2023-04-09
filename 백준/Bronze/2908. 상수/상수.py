a, b = map(int, input().split())
def rev(x):
    x = list(str(x))
    x.reverse()
    return x

a = int(''.join(rev(a)))

b = int(''.join(rev(b)))

print(a if a > b else b)