def find_fac(n):
    fac = []
    
    for i in range(1, n+1):
        if n % i == 0:
            fac.append(i)
    
    return fac

def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        facs_len = len(find_fac(i))
        if facs_len % 2 == 0:
            answer += i
        else:
            answer -= i
            
    
    return answer