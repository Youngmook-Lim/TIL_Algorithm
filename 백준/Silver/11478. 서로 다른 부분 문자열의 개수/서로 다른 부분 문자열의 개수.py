import sys
input = sys.stdin.readline

string = input().strip()

x = len(string)

set = set()
cnt = 0

while cnt < x:
    for i in range(x - cnt):
        set.add(string[i:i+cnt+1])
    cnt += 1

print(len(set))