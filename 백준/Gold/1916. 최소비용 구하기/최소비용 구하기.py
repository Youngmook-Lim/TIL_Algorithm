import sys
from heapq import heappush, heappop

input = sys.stdin.readline

n = int(input())
m = int(input())
INF = 1e9

graph = [[] for _ in range(n + 1)]
for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
price = [INF] * (n + 1)

start, end = map(int, input().split())


def dijkstra(start):
    price[start] = 0
    heap = []
    heappush(heap, (price[start], start))
    while heap:
        p, s = heappop(heap)
        if price[s] < p:
            continue

        for dest, pr in graph[s]:
            total_price = pr + p
            if total_price < price[dest]:
                price[dest] = total_price
                heappush(heap, (total_price, dest))


dijkstra(start)

print(price[end])
