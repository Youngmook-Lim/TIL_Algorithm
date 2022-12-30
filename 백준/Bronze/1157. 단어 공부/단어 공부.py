word = input().upper()
uniquewords = list(set(word))


cnt = []
for i in uniquewords:
    cnt.append(word.count(i))

if cnt.count(max(cnt)) > 1:
    print('?')
else:
    print(uniquewords[cnt.index(max(cnt))])
    