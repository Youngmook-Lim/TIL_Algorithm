def solution(nums):
    set1 = set()
    n = len(nums)
    for i in range(n-1):
        for j in range(i+1, n):
            set1.add(nums[i]+nums[j])
    
    return sorted(list(set1))