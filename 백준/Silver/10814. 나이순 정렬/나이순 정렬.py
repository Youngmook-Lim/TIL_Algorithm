import sys
input = sys.stdin.readline
n = int(input())

students = []
for _ in range(n):
    age, name = map(str, input().strip().split())
    age = int(age)
    students.append((age, name))

students.sort(key=lambda x: (x[0]))

for i in students:
    print(i[0], i[1])