N,M=map(int,input().split())
lst = list(map(int,input().split()))
interval_sum=0
end=0
count=0

for start in range(N):
    while interval_sum<M and end<N:
        interval_sum+=lst[end]
        end+=1
    if interval_sum==M:
        count+=1
    interval_sum-=lst[start]

print(count)