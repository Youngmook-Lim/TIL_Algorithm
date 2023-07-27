string = input()

nums = string.split('-')

total = 0

for i in range(len(nums)):
    spl = nums[i].split('+')
    if len(spl) == 1:
        if i == 0:
            total += int(nums[i])
        else:
            total -= int(nums[i])
    else:
        spl_int = list(map(int, spl))
        if i == 0:
            total += sum(spl_int)
        else:
            total -= sum(spl_int)

print(total)
