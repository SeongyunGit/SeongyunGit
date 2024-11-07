N = int(input())
lst = [int(input()) for _ in range(N)]
dp = [0] * (N+3)
dp[0] = lst[0]
if N==1:
    print(lst[0])
    exit()

dp = [[0, 0, 0] for _ in range(N)]
for i in range(N):
    dp[i][0] = dp[i - 1][2] + lst[i]
    dp[i][1] = dp[i - 1][0] + lst[i]
    dp[i][2] = max(dp[i - 1][1], dp[i - 1][0], dp[i - 1][2])

print(max(dp[N-1]))
