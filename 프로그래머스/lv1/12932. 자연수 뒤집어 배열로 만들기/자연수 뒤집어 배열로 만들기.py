def solution(n):
    sol = []
    for i in range(len(str(n))-1, -1,-1):
        sol.append(int(str(n)[i]))
    return sol