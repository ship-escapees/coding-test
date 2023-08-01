from collections import deque

def solution(maps):
    # goal
    gx = len(maps)
    gy = len(maps[0])

    # 4개방향
    direc = [[1, 0], [-1, 0], [0, 1], [0, -1]]

    que = deque()
    que.append((0, 0, 1)) # 가장 처음 좌표와 이동횟수 저장

    while que:
        x, y, cnt = que.popleft()  # 가장 왼쪽값을 pop

        for i in range(4): # 4개 방향 각각 돌려 체크
            # move
            mx = x + direc[i][0]
            my = y + direc[i][1]

            if mx == gx - 1 and my == gy - 1:  # 골 도착
                return cnt + 1;

            if (-1 < mx < gx) and (-1 < my < gy) and maps[mx][my] == 1:  # 벽 체그, 갈 수있는지 1 체크
                que.append((mx, my, cnt + 1))  # 가장 최신 좌표와 이동횟수 저장
                maps[mx][my] = 0  # 이미 갔던 곳이라 0으로 전환 다시 체크 안하도록

    return -1