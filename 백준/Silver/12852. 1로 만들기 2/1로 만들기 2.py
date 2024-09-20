N=int(input())
dp=[i for i in range(N+1)]
dp[1]=0
history=[i for i in range(N+1)]
history[1]=0
for i in range(2,N+1):
    dp[i] = dp[i-1] + 1
    history[i] = i-1
    if i%3==0 and dp[i]>dp[i//3] + 1:
        dp[i]=dp[i//3] + 1
        history[i] = i//3
    if i%2==0 and dp[i]>dp[i//2] + 1:
        dp[i] = dp[i//2] + 1
        history[i] = i//2
print(dp[N])
print(N,end=" ")
while history[N]!=0:
    print(history[N],end=" ")
    N=history[N]