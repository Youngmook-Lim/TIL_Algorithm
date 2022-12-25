n = int(input())
cnt = 0
number = 0
while True:
    if '666' in str(number):
        cnt += 1
        if cnt == n:
            break
        else:
            number += 1
    else:
        number += 1
print(number)