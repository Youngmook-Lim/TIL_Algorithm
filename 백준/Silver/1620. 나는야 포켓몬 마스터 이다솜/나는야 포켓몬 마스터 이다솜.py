import sys

input = sys.stdin.readline

n, m = map(int, input().split())

dict = {}

for i in range(n):
    a = input().strip()
    dict[i+1] = a
    dict[a] = i+1

for _ in range(m):
    question = input().strip()
    if question.isdigit():
        print(dict[int(question)])
    else:
        print(dict[question])
