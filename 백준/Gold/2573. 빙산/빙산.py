from collections import deque

def dfs(i,j):
    count=1
    visited=[[0]*M for _ in range(N)]
    visited[i][j]=1
    quene=deque()
    quene.append((i,j))
    while quene:
        c,r = quene.popleft()
        for i in range(4):
            ni, nj = c + di[i], r + dj[i]
            if 0 <= ni < N and 0 <= nj < M and mapping[ni][nj] != 0 and visited[ni][nj]==0:
                visited[ni][nj]=1
                quene.append((ni,nj))
                count+=1
    return count



def real(stack):
    global time
    co=0
    while stack:
        a,b,c=stack.pop()
        mapping[a][b]=c
        if c!=0:
            co+=1

    for i in range(N):
        for j in range(M):
            if mapping[i][j]>0:
                if co == dfs(i,j):
                    time+=1
                    island()
                else:
                    return
def island():
    stack=[]
    for i in range(N):
        for j in range(M):
            if mapping[i][j] > 0:
                count=0
                for k in range(4):
                    ni, nj = i + di[k], j + dj[k]
                    if 0 <= ni < N and 0 <= nj < M and mapping[ni][nj] == 0:
                        count+=1
                if mapping[i][j]-count<0:
                    a=0
                else:
                    a= mapping[i][j]-count
                stack.append((i,j,a))
    real(stack)

di=[-1,1,0,0]
dj=[0,0,-1,1]

N,M=map(int,input().split())
mapping=[list(map(int,input().split())) for _ in range(N)]
time=1

island()
count=0
for i in range(N):
    for j in range(M):
        if mapping[i][j]>0:
            count+=1
if time==1:
    print(0)
elif count==0:
    print(0)
else:
    print(time)

