from itertools import combinations
def dfs(a,b,co):
    stack=[]
    stack.append((a,b))
    while stack:
        c,r=stack.pop()
        for k in range(4):
            ni,nj=c+di[k],r+dj[k]
            if 0<=ni<5 and 0<=nj<5 and visited[ni][nj]==0:
                visited[ni][nj]=1
                for x,y in i:
                    if ni==x and nj==y:
                        stack.append((ni,nj))
                        co+=1


    return co

di=[-1,1,0,0]
dj=[0,0,-1,1]
cos=[[i,j] for i in range(5) for j in range(5)]
mapping=[list(input()) for _ in range(5)]
total=0

for i in combinations(cos,7):
    count=0
    for x,y in i:
        if mapping[x][y]=='S':
            count+=1
    if count>=4:
        visited = [[0] * 5 for _ in range(5)]
        visited[i[0][0]][i[0][1]]=1
        co=1
        if dfs(i[0][0],i[0][1],co)==7:
            total+=1

print(total)