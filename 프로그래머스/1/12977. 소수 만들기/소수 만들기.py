def check(n):

    flag = 0
    for i in range(2, n):
        if n % i == 0:
            flag = 1
            break
    
    if flag == 1:
        return False
    else:
        return True

cnt = 0

def solution(nums):
    global cnt
    n = len(nums)
    for i in range(n-2):
        for j in range(i+1, n-1):
            for k in range(j+1, n):
                num = nums[i] + nums[j] + nums[k]
                if check(num):
                    cnt += 1

    return cnt