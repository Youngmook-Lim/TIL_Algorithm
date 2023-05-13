while True:
    n = int(input())
    if n == -1:
        break
    factors = []
    for i in range(1, n):
        if n % i == 0:
            factors.append(i)
    if sum(factors) == n:
        print(f"{n} = 1", end=' ')
        for i in factors[1:]:
            print('+', i, end=' ')
    else:
        print(n, 'is NOT perfect.')