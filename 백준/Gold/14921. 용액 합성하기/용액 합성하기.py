N=int(input())
lst = list(map(int,input().split()))
start=0
end=N-1
real = lst[start]+lst[end]
while start<end:
    temp=lst[start]+lst[end]
    if abs(real)>abs(temp):
        real=temp

    if temp<0:
        start+=1
    else:
        end-=1

print(real)