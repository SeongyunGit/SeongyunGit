N=int(input())
lst=[0,1,2,3]
for _ in range(N):
    a,b=map(int,input().split())
    lst[a],lst[b]=lst[b],lst[a]
print(lst.index(1))
