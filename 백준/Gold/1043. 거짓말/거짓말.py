import sys

input = sys.stdin.readline

n, m = map(int, input().split())

truths = set(list(map(int, input().split()))[1:])

parties = [list(map(int, input().split()))[1:] for _ in range(m)]

people = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)


def dfs(start):
    visited[start] = 1
    truths.add(start)
    for i in people[start]:
        if visited[i] == 0:
            dfs(i)


for party in parties:
    for i in party:
        for j in party:
            if i == j:
                continue
            people[i].append(j)

for party in parties:
    if set(party) & truths:
        for i in set(party) - truths:
            dfs(i)
            visited = [0] * (n + 1)

cnt = 0

for party in parties:
    if not set(party) & truths:
        cnt += 1

print(cnt)
