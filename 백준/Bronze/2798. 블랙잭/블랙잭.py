n, m = map(int, input().split())
cards = list(map(int, input().split()))[:n]

sum = 0
dif = 300000

for i in range(len(cards)-2):
    for j in range(i + 1, len(cards)-1):
        for k in range(j + 1, len(cards)):
            total = cards[i] + cards[j] + cards[k]
            if 0 <= m - total < dif:
                dif = m - total
                sum = total

print(sum)
