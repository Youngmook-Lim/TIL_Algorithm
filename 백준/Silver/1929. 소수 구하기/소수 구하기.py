m, n = map(int, input().split())

def prime_list(m,n):
    n += 1
    sieve = [True] * n

    k = int(n**0.5)
    for i in range(2, k+1):
        if sieve[i] == True:
            for j in range(i+i, n, i):
                sieve[j] = False

    for i in range(m, n):
        if sieve[i] == True and i > 1:
            print(i)

prime_list(m,n)