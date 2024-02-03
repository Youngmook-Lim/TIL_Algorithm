def solution(n, lost, res):
    res = set(res)
    
    lost_set = set()
    
    for i in lost:
        if i in res:
            res.remove(i)
        else:
            lost_set.add(i)

    for i in res:
        if i-1 in lost_set:
            lost_set.remove(i-1)
        elif i+1 in lost_set:
            lost_set.remove(i+1)

    return n - len(lost_set)