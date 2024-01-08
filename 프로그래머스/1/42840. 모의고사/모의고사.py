def solution(ans):
    sol = {}
    cnt = 0
    
    for i in range(len(ans)):
        check = (i % 5) + 1
        if check == ans[i]:
            cnt += 1
    
    sol[1] = cnt
    cnt = 0
    
    second = [1,3,4,5]
    for i in range(len(ans)):
        if i % 2 == 0:
            check = 2
        else:
            check = second[(i % 8) // 2]
        
        if check == ans[i]:
            cnt += 1
    
    sol[2] = cnt

    cnt = 0
    
    third = [3,1,2,4,5]
    for i in range(len(ans)):
        check = third[(i % 10) // 2]
        
        if check == ans[i]:
            cnt += 1
    
    sol[3] = cnt
    
    answer = []
    
    maxv = max(sol.values())
    
    for k, v in sol.items():
        if v == maxv:
            answer.append(k)
    
    answer.sort()
    
    return answer