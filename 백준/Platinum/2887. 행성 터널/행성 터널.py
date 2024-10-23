import sys
input = sys.stdin.readline

def find_parent(x):
    if parent[x]!=x:
        parent[x] = find_parent(parent[x])
    return parent[x]
def union(a,b):
    a = find_parent(a)
    b = find_parent(b)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b


N=int(input())
lst = []
for i in range(1,N+1):
    a,b,c=map(int,input().split())
    lst.append((i,a,b,c))

graph=[]

parent = [i for i in range(N+1)]
for i in [1,2,3]:
    sort = sorted(lst, key = lambda x: x[i])
    e = [(abs(b[i] - a[i]), a[0], b[0]) for a, b in zip(sort[:-1], sort[1:])]
    graph += e

graph.sort()
total=0
for c,a,b in graph:
    if find_parent(a)!=find_parent(b):
        union(a,b)
        total+=c
print(total)