x = input()
arr1 = ['F', 'D', 'C', 'B', 'A']
arr2 = {'+': 0.3, '0': 0, '-': -0.3}

if x == 'F':
    print(0.0)
else:
    print(f"{arr1.index(x[0]) + arr2[x[1]]:.1f}")
