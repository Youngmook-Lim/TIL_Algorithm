def solution(s, skip, index):
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    for char in skip:
        alphabet.remove(char)
    
    answer = ''
    
    for x in s:
        idx = alphabet.index(x)
        answer += alphabet[(idx + index) % len(alphabet)]
        
    return answer