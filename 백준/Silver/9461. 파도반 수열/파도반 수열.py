T=int(input())
for _ in range(T):
    N=int(input())
    dp=[0]*(N+3)
    dp[0]=1
    dp[1]=1
    dp[2]=1
    for i in range(3,N+3):
        dp[i]=dp[i-3]+dp[i-2]
    print(dp[N-1])