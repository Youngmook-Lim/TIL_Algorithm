N = int(input())

for i in range(N):
    R, S = input().split()
    print("".join(i * int(R) for i in S))