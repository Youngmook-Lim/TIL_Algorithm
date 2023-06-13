import sys
input = sys.stdin.readline

n = int(input())

nums = list(map(int, input().split()))[:n]

nums_s = sorted(list(set(nums)))
dic = {nums_s[i] : i for i in range(len(nums_s))}

for i in nums:
    print(dic[i], end=' ')