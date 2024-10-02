def permutation(m,l,lst):
    if len(l)==m:
        a=''.join(str(i) for i in l)
        if a not in visited:
            print(*l)
            visited.add(a)
        return
    for i in range(len(lst)):
        l.append(lst[i])
        permutation(m,l,lst)
        l.pop()


N,M =map(int,input().split())
lst=list(map(int,input().split()))
lst.sort()
visited=set()
permutation(M,[],lst)