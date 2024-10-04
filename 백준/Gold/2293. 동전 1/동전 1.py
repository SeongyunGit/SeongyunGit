N,K = map(int,input().split())
lst = [int(input()) for _ in range(N)]
lst.sort()
dp=[0]*(K+1)
dp[0]=1
for coin in lst:
    for i in range(coin,K+1):
        dp[i]+=dp[i-coin]
print(dp[K])
