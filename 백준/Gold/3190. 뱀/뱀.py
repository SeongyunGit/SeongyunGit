from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
direction={
    0:[2,3],
    1:[3,2],
    2:[1,0],
    3:[0,1],
}

def snackmove(a,b,dir):
    global time,snakebody
    ni,nj=a + di[dir],b+dj[dir]
    if 0<=ni<N and 0<=nj<N and (mapping[ni][nj]==0 or mapping[ni][nj]==1):
        if mapping[ni][nj]==1:
            mapping[ni][nj]=-1
            snakebody.append((ni,nj))
        else:
            mapping[ni][nj]=-1
            snakebody.append((ni,nj))
            x,y=snakebody.popleft()
            mapping[x][y]=0

        time+=1
        for x,y in lst:
            if x==time:
                if y=='D':
                    dir=direction[dir][1]
                else:
                    dir=direction[dir][0]

        snackmove(ni,nj,dir)

    else:
        return

di=[-1,1,0,0]
dj=[0,0,-1,1]

N=int(input())
mapping=[[0 for _ in range(N)] for _ in range(N)]
M=int(input())
for _ in range(M):
    a,b=map(int,input().split())
    mapping[a-1][b-1]=1
L=int(input())
lst=deque()
for _ in range(L):
    a,b=map(str,input().split())
    lst.append((int(a),b))
snakebody=deque()
mapping[0][0]=-1
time=0
snakebody.append((0,0))
snackmove(0,0,3)
print(time+1)