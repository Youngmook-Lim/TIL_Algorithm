n, m = map(int, input().split())

s = []

def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    for i in range(1, n+1):
        if i in s:
            continue
        if not s:
            s.append(i)
            dfs()
            s.pop()
        else:
            if i < s[-1]:
                continue
            else:
                s.append(i)
                dfs()
                s.pop()

dfs()