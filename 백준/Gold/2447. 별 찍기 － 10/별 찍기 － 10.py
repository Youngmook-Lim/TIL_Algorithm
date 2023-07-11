def draw_stars(n):
    if n == 3:
        return ['***', '* *', '***']

    Stars = draw_stars(n//3)
    L = []

    for star in Stars:
        L.append(star * 3)
    for star in Stars:
        L.append(star + ' ' * int(n//3) + star)
    for star in Stars:
        L.append(star * 3)

    return L

n = int(input())

print('\n'.join(draw_stars(n)))