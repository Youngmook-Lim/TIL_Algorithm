def solution(numbers, hand):
    pad = [[1,2,3], [4,5,6], [7,8,9], ['*', 0, '#']]
    l_position = '*'
    r_position = '#'
    answer = ''
    for i in numbers:
        if i in [1,4,7]:
            l_position = i
            answer = answer + 'L'
        elif i in [3,6,9]:
            r_position = i
            answer = answer + 'R'
        else:
            dict = {}
            for j in range(4):
                for k in range(3):
                    if pad[j][k] == l_position:
                        dict['l'] = [j, k]
                    if pad[j][k] == r_position:
                        dict['r'] = [j, k]
                    if pad[j][k] == i:
                        dict['i'] = [j, k]
            # print(dict)
            l_distance = abs(dict['l'][0] - dict['i'][0]) + abs(dict['l'][1] - dict['i'][1])
            r_distance = abs(dict['r'][0] - dict['i'][0]) + abs(dict['r'][1] - dict['i'][1])
            if l_distance > r_distance:
                r_position = i
                answer = answer + 'R'
            elif l_distance < r_distance:
                l_position = i
                answer = answer + 'L'
            else:
                if hand == 'right':
                    r_position = i
                    answer = answer + 'R'
                else:
                    l_position = i
                    answer = answer + 'L'
    print(answer)
    return answer