set1 = set()
set_compare = set()

for i in range(1, 31):
    set_compare.add(i)

for _ in range(28):
    set1.add(int(input()))

ans = sorted(set_compare - set1)

for i in ans:
    print(i)