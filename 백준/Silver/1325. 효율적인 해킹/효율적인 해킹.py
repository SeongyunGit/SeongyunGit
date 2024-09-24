import sys
input = sys.stdin.readline

def checker(start):
    visited[start]=1
    stack=[]
    stack.append(start)
    while stack:
        now=stack.pop()
        for next in graph[now]:
            if visited[next]==0:
                visited[next]=1
                stack.append(next)
    ans.append(sum(visited))

N,M=map(int,input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a,b = map(int,input().split())
    graph[b].append(a)
ans=[]
for i in range(1,N+1):
    visited=[0]*(N+1)
    checker(i)
an=[]
for i in range(N):
    if ans[i]==max(ans):
        an.append(i+1)
print(*an)