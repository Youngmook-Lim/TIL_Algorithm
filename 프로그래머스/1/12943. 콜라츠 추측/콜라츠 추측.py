cnt = 0

def solution(num):
    global cnt
    if num == 1:
        return cnt
    if cnt >= 500:
        return -1
    
    if num % 2 == 0:
        cnt += 1
        return solution(num // 2)

    else:
        cnt += 1
        return solution(num * 3 + 1)