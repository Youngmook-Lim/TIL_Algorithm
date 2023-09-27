def solution(keymap, targets):
    map = {}
    
    for key in keymap:
        for j in range(1, len(key) + 1):
            map[key[j - 1]] = min(map.get(key[j - 1], 101), j)

    answer = []

    for target in targets:
        sum = 0
        for x in target:
            if x not in map:
                sum = -1
                break
            else:
                sum += map[x]
        answer.append(sum)

    return answer