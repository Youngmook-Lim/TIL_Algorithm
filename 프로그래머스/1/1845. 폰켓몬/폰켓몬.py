def solution(nums):
    n = len(nums) // 2
    poke_types = len(set(nums))
    return min(n, poke_types)