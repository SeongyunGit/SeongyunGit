import heapq

def bfs(start):
    distance=[float('inf') for _ in range(N+1)]
    stack=[]
    distance[start]=0
    heapq.heappush(stack,(0,start))
    while stack:
        dist,now=heapq.heappop(stack)
        if dist> distance[now]:
            continue

        for next,cost in quene[now]:
            next_cost = cost + dist
            if next_cost<distance[next]:
                distance[next]=next_cost
                heapq.heappush(stack,(next_cost,next))

    for i in range(1,N+1):
        if distance[i]==float('inf'):
            return False
    return True

def find_parent(parent,x):
    if parent[x] != x:
        parent[x] = find_parent(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b


N,M,K = map(int,input().split())
graph = []
for i in range(M):
    a,b=map(int,input().split())
    graph.append((i+1,a,b))
    graph.append((i+1,b,a))
graph.sort()
ans=[]
for i in range(K):
    parent=[i for i in range(N+1)]
    total=0
    count=1
    quene=[[] for _ in range(N+1)]
    for cost,a,b in graph:
        if find_parent(parent,a) != find_parent(parent,b):
            union(parent,a,b)
            total+=cost
            quene[a].append((b,cost))
            quene[b].append((a,cost))
    if bfs(1):
        ans.append(total)
    else:
        ans.append(0)
    graph.pop(0)
    graph.pop(0)

print(*ans)