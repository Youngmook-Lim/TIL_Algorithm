def solution(price, money, count):
    total = sum(range(price, price * count + 1, price))
    print(total)
    if money - total >= 0:
        return 0
    else:
        return total - money