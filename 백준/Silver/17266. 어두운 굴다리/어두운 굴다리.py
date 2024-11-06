N = int(input())
M = int(input())
lst = list(map(int, input().split()))

start = 0
end = N

result = float('inf')
while start <= end:
    mid = (start + end) // 2
    is_true = True
    is_false = True
    count = 0
    for l in range(M):
        if l == 0:
            if lst[l] - mid <= 0:
                is_true = False
        if l == M - 1:
            if lst[l] + mid >= N:
                is_false = False
        if 0 < l <= M - 1 and lst[l - 1] + mid >= lst[l] - mid:
            count += 1

    if count >= M - 1 and is_true == False and is_false == False:
        result = min(mid, result)
        end = mid - 1
    else:
        start = mid + 1

print(result)
