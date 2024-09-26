def connection(start):
    visited[start]=1
    stack=[]
    stack.append(start)
    while stack:
        c=stack.pop()
        for next in graph[c]:
            if visited[next]==0:
                visited[next]=1
                stack.append(next)


N,M=map(int,input().split())
a,*b=map(int,input().split())
count=0
visited=[0]*(N+1)
graph=[[] for _ in range(N+1)]
lst=[]
for _ in range(M):
    c,*d=map(int,input().split())
    lst.append((c,d))
    if c==1:
        continue
    else:
        for i in range(c-1):
            for j in range(i+1,c):
                graph[d[i]].append(d[j])
                graph[d[j]].append(d[i])
for i in range(a):
    if visited[b[i]]==0:
        connection(b[i])

for x,y in lst:
    is_true = True
    for z in y:
        if a==0:
            continue
        else:
            if visited[z]==1:
                is_true=False
    if is_true==True:
        count+=1
print(count)





