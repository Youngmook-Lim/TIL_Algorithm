def solution(a, b):
    days = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    numd = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    totaldays = sum(numd[0:(a-1)]) + b
    
    return days[totaldays % 7 - 1]