S = input()
alphabet = 'abcdefghijklmnopqrstuvwxyz'

for i in range(len(alphabet)):
    try:
        print(S.index(alphabet[i]), end=" ")
    except ValueError:
        print(-1, end=" ")