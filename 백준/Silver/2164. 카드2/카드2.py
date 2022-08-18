import sys
input = sys.stdin.readline
n = int(input())

square = 2

while True:
    if n == 1 or n == 2:
        print(n)
        break
    square *= 2
    if square >= n:
        print(int((n-square/2)*2))
        break

