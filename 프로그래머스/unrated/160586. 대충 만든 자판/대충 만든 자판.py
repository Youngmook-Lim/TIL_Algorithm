def solution(keymap, targets):
    map = getKeyMap(keymap)

    answer = []

    for target in targets:
        sum = 0
        flag = True
        for x in target:
            if x not in map:
                answer.append(-1)
                flag = False
                break
            else:
                sum += map[x]
        if flag:
            answer.append(sum)

    return answer


def getKeyMap(keymap):
    dic = dict()

    for key in keymap:
        for j in range(1, len(key) + 1):
            dic[key[j - 1]] = min(dic.get(key[j - 1], 101), j)
            # if key[j - 1] in dic:
            #     dic[key[j - 1]] = min(dic[key[j - 1]], j)
            # else:
            #     dic[key[j - 1]] = j

    return dic