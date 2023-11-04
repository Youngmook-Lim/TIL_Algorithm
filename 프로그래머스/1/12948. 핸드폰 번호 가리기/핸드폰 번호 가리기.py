def solution(p):
    answer = ''
    length = len(p)
    for i, v in enumerate(p):
        if i < length - 4:
            answer += '*'
        else:
            answer += v
    print(answer)
    return answer