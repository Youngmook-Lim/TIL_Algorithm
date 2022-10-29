from collections import deque
import sys

input = sys.stdin.readline


def D(n):
    return (2 * n) % 10000


def S(n):
    if n == 0:
        return 9999
    else:
        return n - 1


def L(n):
    return (n * 10 + n // 1000) % 10000
    # d1, d2, d3, d4 = list(f"{n:04}")
    # return int(''.join([d2, d3, d4, d1]))


def R(n):
    return (n // 10 + (n % 10) * 1000) % 10000
    # d1, d2, d3, d4 = list(f"{n:04}")
    # return int(''.join([d4, d1, d2, d3]))


T = int(input())

for _ in range(T):
    a, b = map(int, input().split())

    q = deque([])
    q.append([a, ''])
    visited = [0] * 10000

    while q:
        x, cmd = q.popleft()
        visited[x] = 1

        if x == b:
            print(cmd)
            break

        l = L(x)
        if not visited[l]:
            q.append([l, cmd + 'L'])
            visited[l] = 1
            
        r = R(x)
        if not visited[r]:
            q.append([r, cmd + 'R'])
            visited[l] = 1

        d = D(x)
        if not visited[d]:
            q.append([d, cmd + 'D'])
            visited[l] = 1

        s = S(x)
        if not visited[s]:
            q.append([s, cmd + 'S'])
            visited[l] = 1
