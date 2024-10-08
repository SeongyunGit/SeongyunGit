import sys
input = sys.stdin.readline

def find_parent(parent,x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent,a ,b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a<b:
        parent[b] =a
    else:
        parent[a] = b



N,M,K = map(int,input().split())
develop=list(map(int,input().split()))

parent=[i for i in range(N+1)]
for i in develop:
    parent[i]=0
graph=[]
for _ in range(M):
    a,b,c=map(int,input().split())
    graph.append((c,a,b))
    graph.append((c,b,a))
graph.sort()
total=0
for cost,a,b in graph:
    if find_parent(parent,a) != find_parent(parent,b):
        union(parent,a,b)
        total+= cost
print(total)