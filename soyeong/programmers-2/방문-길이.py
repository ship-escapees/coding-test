def solution(dirs):
    x, y = 0, 0  # 최초 좌표
    history = set()  # 지나간 길을 자동으로 걸러줄 set()
    direction = {
        'U': (0, 1),  # (x, y)
        'D': (0, -1),
        'L': (-1, 0),
        'R': (1, 0),
    }

    for dir in dirs:
        dx, dy = direction[dir]
        if (-5 <= x + dx <= 5) and (-5 <= y + dy <= 5):  # 경계 판단

            # 2점을 경계로 한쪽에서 왔다가 가도, 다른쪽에서 왔다가 가도 같은 길이므로 두 방향을 모두 기록
            history.add((x, y, x + dx, y + dy))
            history.add((x + dx, y + dy, x, y))

            # 현재 좌표 갱신
            x += dx
            y += dy

    return len(set(history)) // 2  # 한번 간길을 두방향으로 저장하므로 둘로 나누어 값을 반환