n = int(input())

dict = {}

for i in range(n):
    node, left, right = input().split()
    dict[node] = [left, right]


def pre(char):
    if char != '.':
        print(char, end='')
        pre(dict[char][0])
        pre(dict[char][1])


def ino(char):
    if char != '.':
        ino(dict[char][0])
        print(char, end='')
        ino(dict[char][1])


def post(char):
    if char != '.':
        post(dict[char][0])
        post(dict[char][1])
        print(char, end='')


pre('A')
print()
ino('A')
print()
post('A')
