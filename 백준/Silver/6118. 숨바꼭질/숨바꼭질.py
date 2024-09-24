from collections import deque

def bfs(start):
    quene=deque()
    visited[start]=0
    quene.append(start)
    while quene:
        now=quene.popleft()
        for next in graph[now]:
            if visited[next] == -1:
                visited[next]=visited[now]+1
                quene.append(next)


N,M=map(int,input().split())
graph=[[] for _ in range(N+1)]
for _ in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
visited=[-1]*(N+1)
bfs(1)

print(visited.index(max(visited)),max(visited),visited.count(max(visited)))