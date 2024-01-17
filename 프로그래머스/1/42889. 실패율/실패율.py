def solution(N, stages):
    # stages.sort()
    arr = []
    num = len(stages)
    
    for i in range(1, N+1):
        fail = stages.count(i)
        if num > 0:
            arr.append((i, fail/num))
        else:
            arr.append((i, 0))
        num -= fail
    
    arr.sort(key= lambda x: x[1], reverse=True)
    
    sol = []
    for i in arr:
        sol.append(i[0])
    
    return sol