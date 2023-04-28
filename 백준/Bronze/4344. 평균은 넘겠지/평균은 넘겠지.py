C = int(input())
for i in range(C):
    N = list(map(int, input().split()))
    sum = 0
    n = 0
    for i in range(1, len(N)):
        sum += N[i]
    avg = sum / (len(N) - 1)
    for i in range(1, len(N)):
        if N[i] > avg:
            n += 1
    perc = n / (len(N)-1) *100
    print(f"{perc:.3f}%")