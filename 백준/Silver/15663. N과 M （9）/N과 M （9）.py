import sys

input = sys.stdin.readline

n, m = map(int, input().split())

nums = list(map(int, input().split()))
visited = [0 for _ in range(n)]
nums.sort()

temp = []


def dfs():
    if len(temp) == m:
        print(*temp)
        return
    overlap = 0
    for i in range(n):
        if visited[i] == 0 and overlap != nums[i]:
            visited[i] = 1
            temp.append(nums[i])
            overlap = nums[i]
            dfs()
            temp.pop()
            visited[i] = 0


dfs()
