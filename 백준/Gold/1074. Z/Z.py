def solved(size, x, y):
    global result

    if x == r and y == c:
        print(result)
        exit()

    if size == 1:
        result += 1
        return

    if not (x <= r < x + size and y <= c < y + size):
        result += size * size
        return

    next = size // 2
    solved(next, x, y)
    solved(next, x, y + next)
    solved(next, x + next, y)
    solved(next, x + next, y + next)


N, r, c = map(int, input().split())
result = 0
solved(2 ** N, 0, 0)
