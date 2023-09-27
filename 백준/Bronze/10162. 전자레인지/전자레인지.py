t = int(input())

a, b, c = 0, 0, 0

# a = 300sec, b = 60sec, c = 10sec

if t // 300 > 0:
    a += t//300
    t -= 300*(t//300)

if t // 60 > 0:
    b += t//60
    t -= 60*(t//60)

if t % 10 == 0:
    c += t//10
    print(a, b, c)

else:
    print(-1)
