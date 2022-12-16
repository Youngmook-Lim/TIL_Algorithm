N = int(input())

cnt = 0
first_N = N

while True:

    N = N%10*10 + ((N //10)+N%10)%10
    cnt += 1

    if N == first_N:
        print(cnt)
        break