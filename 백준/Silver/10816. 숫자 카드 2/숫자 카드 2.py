from collections import Counter
from sys import stdin
input = stdin.readline

n = input()
arr = input().split()
m = input()
nums = input().split()

C = Counter(arr)

for m in nums:
    print(C[m], end=' ')