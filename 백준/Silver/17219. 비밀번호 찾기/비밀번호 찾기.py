import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())

dict = {}
for _ in range(n):
    ad, pw = input().strip().split()
    dict[ad] = pw

for _ in range(m):
    a = input().strip()
    print(dict[a])