import math

def find_parent(x):
    if parent[x]!=x:
        x = find_parent(parent[x])
    return parent[x]
def union(a,b):
    a = find_parent(a)
    b = find_parent(b)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b

N=int(input())
lst=[]
for _ in range(N):
    a,b=map(float,input().split())
    lst.append((a,b))

graph=[]
for i in range(N-1):
    for j in range(i+1,N):
        graph.append((math.sqrt((lst[i][0]-lst[j][0])**2 + (lst[i][1]-lst[j][1])**2),i,j))
        graph.append((math.sqrt((lst[i][0]-lst[j][0])**2 + (lst[i][1]-lst[j][1])**2),j,i))
parent = [i for i in range(N+1)]
graph.sort()
result=0
for c,a,b in graph:
    if find_parent(a) != find_parent(b):
        union(a,b)
        result+=c


print(f"{result:.2f}")