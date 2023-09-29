t = int(input())

for i in range(t):
    y, k = 0, 0
    for _ in range(9):
        yy, kk = map(int, input().split())
        y += yy
        k += kk
    
    if y > k:
        print('Yonsei')
    elif y < k:
        print('Korea')
    else:
        print('Draw')
        