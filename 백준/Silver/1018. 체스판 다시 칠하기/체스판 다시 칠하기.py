n, m = map(int, input().split())

test1 = ['WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW']
test2 = ['BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB', 'BWBWBWBW', 'WBWBWBWB']
arr = []

for _ in range(n):
    arr.append(input()[:m])

result = []

for i in range(n-7):
    for j in range(m-7):
        count1 = 0
        count2 = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if arr[k][l] != test1[k-i][l-j]:
                    count1 += 1
                if arr[k][l] != test2[k-i][l-j]:
                    count2 += 1
        result.append(count1)
        result.append(count2)

print(min(result))