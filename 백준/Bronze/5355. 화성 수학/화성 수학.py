t = int(input())
nums =[]
for _ in range(t):
    nums.append(list(input().split()))

results =[]
for i in nums:
    result = float(i[0])
    for j in range(1, len(i)):
        if i[j] == '@':
            result *= 3
        elif i[j] == '%':
            result += 5
        elif i[j] == '#':
            result -= 7
    results.append(result)

for i in results:
    print(f"{i:.2f}")