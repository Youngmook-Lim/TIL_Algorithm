import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []

for _ in range(n):
    a = int(input())
    a = a * -1
    if a == 0:
        try:
            x = heapq.heappop(heap)
            print(x * -1)
        except:
            print(0)
    else:
        heapq.heappush(heap, a)