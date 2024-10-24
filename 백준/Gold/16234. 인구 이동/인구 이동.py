from collections import deque

def bfs(a,b):
    quene=deque()
    stack=[]
    stack.append((a,b))
    quene.append((a,b))
    visited[a][b]=1
    total=0
    total+=mapping[a][b]
    while quene:
        i,j=quene.popleft()
        for k in range(4):
            ni,nj = i+di[k],j+dj[k]
            if 0<=ni<N and 0<=nj<N and L<=abs(mapping[i][j]-mapping[ni][nj])<=R and visited[ni][nj]==0:
                visited[ni][nj]=1
                total+=mapping[ni][nj]
                stack.append((ni,nj))
                quene.append((ni,nj))

    if len(stack)!=1:
        total=total//len(stack)
        for a,b in stack:
            mapping[a][b]=total



di=[0,0,1,-1]
dj=[1,-1,0,0]

N,L,R = map(int,input().split())
mapping=[list(map(int,input().split())) for _ in range(N)]

result=0
is_true = True
while True:
    count=0
    visited=[[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if visited[i][j]==0:
                bfs(i, j)
                count+=1

    if count==N*N:
        break
    result+=1

print(result)