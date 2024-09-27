from collections import deque


def bfs():
    while quene:
        x, y, z = quene.popleft()
        for l in range(6):
            nx, ny, nz = x + dk[l], y + dj[l], z + di[l]
            if 0 <= nx < L and 0 <= ny < R and 0 <= nz < C and visited[nx][ny][nz] == -1 and building[nx][ny][
                nz] == '.':
                visited[nx][ny][nz] = visited[x][y][z] + 1
                quene.append((nx, ny, nz))
            elif 0 <= nx < L and 0 <= ny < R and 0 <= nz < C and visited[nx][ny][nz] == -1 and building[nx][ny][
                nz] == 'E':
                visited[nx][ny][nz] = visited[x][y][z] + 1
                return visited[nx][ny][nz]

    return 0


di = [1, -1, 0, 0, 0, 0]
dj = [0, 0, -1, 1, 0, 0]
dk = [0, 0, 0, 0, -1, 1]

while True:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        break
    building = []
    for _ in range(L):
        floor = [list(input()) for _ in range(R)]
        temp = input()
        building.append(floor)
    visited = [[[-1 for _ in range(C)] for _ in range(R)] for _ in range(L)]
    quene = deque()
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if building[i][j][k] == 'S':
                    quene.append((i, j, k))
                    visited[i][j][k] = 0
    result = bfs()
    if result > 0:
        print(f'Escaped in {result} minute(s).')
    else:
        print('Trapped!')
