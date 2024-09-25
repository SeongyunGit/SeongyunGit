N,M = map(int,input().split())
mapping = [list(map(int,input().split())) for _ in range(N)]
dp=[[0]*M for _ in range(N)]
dp[0][0]=mapping[0][0]
for i in range(N):
    for j in range(M):
        if 0<=j+1<M:
            dp[i][j+1]=max(dp[i][j]+mapping[i][j+1],dp[i][j+1])
        if 0<=i+1<N:
            dp[i+1][j]=max(dp[i][j]+mapping[i+1][j],dp[i+1][j])
        if 0<=i+1<N and 0<=j+1<M:
            dp[i+1][j+1]=max(dp[i][j]+mapping[i+1][j+1],dp[i+1][j+1])

print(dp[N-1][M-1])