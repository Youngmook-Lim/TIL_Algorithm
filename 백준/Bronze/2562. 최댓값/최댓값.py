a = []
i = 0
while i < 9:
    a.append(int(input()))
    i += 1
a_max = max(a)
print(a_max)
print(a.index(a_max)+1)