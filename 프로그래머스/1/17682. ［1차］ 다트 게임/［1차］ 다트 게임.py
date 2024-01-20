import re


def solution(dartResult):
    sdt = {'S': 1, 'D':2, 'T': 3}
    opt = {'*': 2, '': 1, '#': -1}
    p = re.compile('(\d+)([SDT])([*#]?)')
    m = p.findall(dartResult)
    for i in range(len(m)):
        if i > 0 and m[i][2] == '*':
            m[i] = int(m[i][0]) ** sdt[m[i][1]] * opt[m[i][2]] 
            m[i-1] *= 2
        else:
            m[i] = int(m[i][0]) ** sdt[m[i][1]] * opt[m[i][2]]
    
    
    return sum(m)