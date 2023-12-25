def solution(array, com):
    sol = []
    for x in com:
        [i, j, k] = x
        i = i-1
        k = k-1
        arr = array[slice(i, j)]
        arr.sort()
        sol.append(arr[k])
    return sol