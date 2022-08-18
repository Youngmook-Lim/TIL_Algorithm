import sys
input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))

arr.sort()

sol = 0

for i in range(n):
    sol += sum(arr[:i+1])

print(sol)