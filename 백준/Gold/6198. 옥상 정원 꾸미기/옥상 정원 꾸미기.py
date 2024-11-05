import sys
input = sys.stdin.readline

N=int(input())
lst=[int(input()) for _ in range(N)]
stack=[]
result=0
for i in lst:
    while stack and stack[-1]<=i:
        stack.pop()
    stack.append(i)

    result += len(stack)-1

print(result)