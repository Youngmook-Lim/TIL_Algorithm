n = int(input())

result = {'Q1': 0, 'Q2': 0, 'Q3': 0, 'Q4': 0, 'AXIS': 0}

for _ in range(n):
    x, y = map(int, input().split())
    if x > 0 and y > 0:
        result['Q1'] += 1
    elif x < 0 and y > 0:
        result['Q2'] += 1
    elif x < 0 and y < 0:
        result['Q3'] += 1
    elif x > 0 and y < 0:
        result['Q4'] += 1
    else:
        result['AXIS'] += 1

result_list = list(result)

print('Q1:', result['Q1'])
print('Q2:', result['Q2'])
print('Q3:', result['Q3'])
print('Q4:', result['Q4'])
print('AXIS:', result['AXIS'])