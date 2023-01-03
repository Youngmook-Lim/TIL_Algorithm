a = input().split(' ')
if a == '':
    print(0)
if '' in a:
    while '' in a:
        a.remove('')
print(len(a))
