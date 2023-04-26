word = list(input())

check = 0
for i in range(len(word)):
    if word[i] != word[len(word)-i-1]:
        check += 1

if check == 0:
    print(1)
else:
    print(0)