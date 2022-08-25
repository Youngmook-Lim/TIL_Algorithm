l = int(input())
string = input()[:l]
num_str = [ord(i) - 96 for i in string]
sum = 0

for i in range(len(num_str)):
    sum += num_str[i] * 31**i

print(sum % 1234567891)