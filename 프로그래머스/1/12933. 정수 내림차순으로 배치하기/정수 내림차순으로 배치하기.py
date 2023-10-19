def solution(n):
    arr = sorted(map(int, str(n)), reverse=True)
    arr = list(map(str, arr))
    return int(''.join(arr))