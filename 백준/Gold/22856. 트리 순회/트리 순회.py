import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
def similar(start):
    global count
    if tree[start][0]!=-1:
        similar(tree[start][0])
        count+=1

    if start==lst[-1]:
        print(count)
        exit(0)
    count+=1
    if tree[start][1]!=-1:
        similar(tree[start][1])
        count+=1

def inorder(start):
    if start==-1:
        return
    inorder(tree[start][0])
    lst.append(start)
    inorder(tree[start][1])

N=int(input())
tree=[[] for _ in range(N+1)]
for _ in range(N):
    a,b,c=map(int,input().split())
    tree[a].append(b)
    tree[a].append(c)
count=0
lst=[]
inorder(1)
similar(1)
