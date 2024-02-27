def solution(n):
    sol = []
    while n > 0:
        if n % 3 != 0:
            sol.append(n % 3)
            n = n // 3
        else:
            sol.append(3)
            n = n // 3 - 1
    sol = ''.join(map(str, reversed(sol)))
    sol = sol.replace('3', '4')
    return sol