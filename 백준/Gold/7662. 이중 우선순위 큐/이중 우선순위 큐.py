import sys
input = sys.stdin.readline

import heapq

T = int(input())

def sync(q):
    while q and not visited[q[0][1]]:
        heapq.heappop(q)


for _ in range(T):
    k = int(input())
    q1, q2 = [], []
    visited = [0] * k
    for i in range(k):
        a, n = input().split()
        n = int(n)

        if a == 'I':
            heapq.heappush(q1, (n, i))
            heapq.heappush(q2, (-n, i))
            visited[i] = 1

        else:
            if n == 1:
                sync(q2)
                if q2:
                    visited[q2[0][1]] = 0
                    heapq.heappop(q2)
            elif n == -1:
                sync(q1)
                if q1:
                    visited[q1[0][1]] = 0
                    heapq.heappop(q1)

    sync(q1)
    sync(q2)

    if not q1:
        print('EMPTY')
    else:
        print(-q2[0][0], q1[0][0])


