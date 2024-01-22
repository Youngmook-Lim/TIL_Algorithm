def solution(lottos, win_nums):
    same_num = set(lottos) & set(win_nums)
    min_score = len(same_num)
    cnt = 0
    for i in lottos:
        if i == 0:
            cnt += 1
    max_score = min_score + cnt
    
    answer = [7 - max_score if max_score > 1 else 6, 7 - min_score if min_score > 1 else 6]
    return answer