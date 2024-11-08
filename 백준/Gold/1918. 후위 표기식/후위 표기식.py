MULTI = {
    "(": 3,
    ")": 3,
    "*": 2,
    "/": 2,
    "+": 1,
    "-": 1}

N = list(input())
result = []
multiple = []

count = 0
for l in N:
    if l.isalnum():
        result.append(l)

    elif len(multiple) == 0:
        multiple.append(l)

    elif l == "(":
        multiple.append(l)

    elif multiple and l == ")":
        while multiple and multiple[-1] != "(":
            result.append(multiple.pop())
        multiple.pop()

    elif multiple and (l in MULTI):
        while multiple and (MULTI[multiple[-1]] >= MULTI[l] and MULTI[multiple[-1]]!=3):
            result.append(multiple.pop())
        multiple.append(l)

if multiple:
    while multiple:
        result.append(multiple.pop())
for x in result:
    print(x,end="")

