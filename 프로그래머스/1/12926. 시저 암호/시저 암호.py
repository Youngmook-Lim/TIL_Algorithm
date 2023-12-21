def solution(s, n):
    arr = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    sol = ''
    for i in s:
        if i.isupper():
            i = i.lower()
            sol += arr[(arr.index(i) + n) % 26].upper()
        elif i.islower():
            sol += arr[(arr.index(i) + n) % 26]
        else:
            sol += ' '
    
    return sol