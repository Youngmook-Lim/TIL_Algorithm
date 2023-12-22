def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for i in range(len(arr)):
        if arr[i] in s:
            s = s.replace(arr[i], str(i))
    answer = int(s)
    return answer