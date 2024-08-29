import sys
sys.setrecursionlimit(10**6)
def bfs(n):
    for i in tree[n]:
        if visited[i]==0:
            visited[i]=1
            bfs(i)                

N,M=map(int,sys.stdin.readline().split())
tree=[[] for _ in range(N+1)]
visited=[0]*(N+1)
for _ in range(M):
    A,B=map(int,sys.stdin.readline().split())
    tree[A].append(B)
    tree[B].append(A)

count=0
for i in range(1,N+1):
    if visited[i]==0:
        bfs(i)
        count+=1
print(count)