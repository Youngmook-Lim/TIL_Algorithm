def solution(id_list, report, k):
    answer = [0] * len(id_list)
    dict = {i : 0 for i in id_list}
        
    for i in set(report):
        a, b = i.split()
        dict[b] += 1
        
    for i in set(report):
        a, b = i.split()
        if dict[b] >= k:
            answer[id_list.index(a)] += 1

    return answer