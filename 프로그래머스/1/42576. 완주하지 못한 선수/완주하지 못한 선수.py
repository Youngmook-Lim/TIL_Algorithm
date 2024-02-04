from collections import Counter

def solution(p, c):
    p_counter = Counter(p)
    c_counter = Counter(c)
    return list(p_counter - c_counter).pop()