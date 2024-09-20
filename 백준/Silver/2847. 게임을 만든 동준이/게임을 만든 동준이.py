N=int(input())
lst=[int(input()) for _ in range(N)]
count=0
for i in range(N-1,0,-1):
    if lst[i]<=lst[i-1]:
        A=lst[i-1]
        lst[i-1] = lst[i]-1
        count+=A-lst[i-1]
print(count)
