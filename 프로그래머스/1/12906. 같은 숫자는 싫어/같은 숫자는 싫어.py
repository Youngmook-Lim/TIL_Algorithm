def solution(arr):
    sol = []
    for i in arr:
        if not sol or i != sol[-1]:
            sol.append(i)
    return sol