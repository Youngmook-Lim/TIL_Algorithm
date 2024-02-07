def solution(s, skip, index):
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    for char in skip:
        alphabet.remove(char)
    
    dic = {}
    for i, char in enumerate(alphabet):
        dic[char] = i
    
    answer = ''
    
    for x in s:
        answer += alphabet[(dic[x] + index) % len(alphabet)]
        
    return answer