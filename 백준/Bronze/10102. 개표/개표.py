v = int(input())

scores = list(input())[:v]

if scores.count('A') > scores.count('B'):
    print('A')
elif scores.count('A') < scores.count('B'):
    print('B')
else:
    print('Tie')