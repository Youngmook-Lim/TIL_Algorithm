h0, m0, s0 = map(int, input().split())
add = int(input())

s1 = (add + s0) % 60
m1 = (m0 + (add + s0) // 60) % 60
h1 = (h0 + (m0 + (add + s0) // 60) // 60) % 24

print(h1, m1, s1)