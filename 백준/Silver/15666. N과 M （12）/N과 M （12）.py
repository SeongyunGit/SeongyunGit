import sys
input = sys.stdin.readline

def permutation(depth,idx):
    if depth==M:
        print(' '.join(map(str,ans)))
        return

    for i in range(idx,len(lst)):
        ans.append(lst[i])
        permutation(depth+1,i)
        ans.pop()

N,M =map(int,input().split())
lst=sorted(set(list(map(int,input().split()))))
lst.sort()
ans=[]
visited=set()
permutation(0,0)
