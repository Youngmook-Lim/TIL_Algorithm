n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()

total = 0

for i in a:
    maxi = max(b)
    total += i * maxi
    b.remove(maxi)

print(total)
