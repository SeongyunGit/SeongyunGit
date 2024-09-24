from collections import deque
def toplogy():
    global total
    result=[]
    quene=deque()
    for i in range(1,N+1):
        if vs[i]==0:
            quene.append(i)
            dp[i]=visited[i]
    while quene:
        now = quene.popleft()
        result.append(now)
        for next in graph[now]:
            vs[next]-=1
            dp[next] = max(dp[now] + visited[next], dp[next])
            if vs[next]==0:
                quene.append(next)



N=int(input())
graph=[[] for _ in range(N+1)]
visited=[0]*(N+1)
vs=[0]*(N+1)
dp=[0]*(N+1)
for i in range(N):
    a,b,*com = map(int,input().split())
    visited[i+1]=a
    for j in com:
        graph[j].append(i+1)
        vs[i+1]+=1

toplogy()
print(max(dp))