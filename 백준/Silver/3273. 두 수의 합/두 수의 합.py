N = int(input())
lst = list(map(int, input().split()))
X = int(input())
lst.sort()
left = 0
right = N - 1
count = 0

while left < right:
    if lst[left] + lst[right] == X:
        left += 1
        count += 1
        right -= 1

    elif lst[left] + lst[right] < X:
        left += 1

    else:
        right -= 1

print(count)