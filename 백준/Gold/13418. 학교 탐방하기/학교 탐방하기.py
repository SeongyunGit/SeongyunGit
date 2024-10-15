import heapq
import sys
input = sys.stdin.readline

def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(a,b):
    a = find_parent(a)
    b = find_parent(b)

    if a>b:
        parent[a]=b
    else:
        parent[b]=a

N,M=map(int,input().split())
L1=[]
L2=[]

for i in range(M+1):
    a,b,c=map(int,input().split())
    heapq.heappush(L1,[c^1,a,b])
    heapq.heappush(L2,[-(c^1),a,b])

parent=[i for i in range(N+1)]

count=0
ans1=0
while count<N:
    c,a,b=heapq.heappop(L1)
    if find_parent(a)!=find_parent(b):
        count+=1
        union(a,b)
        ans1+=c

parent=[i for i in range(N+1)]

count=0
ans2=0
while count<N:
    c,a,b=heapq.heappop(L2)
    if find_parent(a)!=find_parent(b):
        count+=1
        union(a,b)
        ans2+=c

print(ans2*ans2-ans1*ans1)