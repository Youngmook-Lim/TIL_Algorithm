import sys
input = sys.stdin.readline

n = int(input())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, input().split())))

solution = [0, 0, 0]

def sol(x, y, n):
    global solution
    check = matrix[y][x]

    flag = 0
    for i in range(y, y+n):
        for j in range(x, x+n):
            if matrix[i][j] != check:
                flag = 1
                break

    if flag == 0:
        if check == -1:
            solution[0] += 1
            return
        elif check == 0:
            solution[1] += 1
            return
        elif check == 1:
            solution[2] += 1
            return
    else:
        n = n // 3
        for k in range(3):
            for l in range(3):
                sol(x + n*k, y + n*l, n)


sol(0,0,n)

for i in solution:
    print(i)