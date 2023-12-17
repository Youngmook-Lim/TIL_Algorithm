def solution(sizes):
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]
    print(sizes)
    return max(map(int, [i[0] for i in sizes])) * max(map(int, [i[1] for i in sizes]))