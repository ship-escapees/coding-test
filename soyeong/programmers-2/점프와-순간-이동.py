def solution(n):
    jump = 0

    # 목적지 1은 무조건 점프로 이동
    if n == 1:
        return 1

    # 목적지에서 출발지로 반대로 생각
    # 목적지까지 거리에서 2로 나눌수 없는 나머지는 무조건 점프
    # 그리고 2로 나눈 값을 다시 2로 나누어, 나눠지지 않는 나머지는 점프
    # 이를 반복하여 n이 1이 될때까지 반복하고
    # n이 1이되면 무조건 점프로 이동해야하므로 1을 더하여 return
    while n > 1:
        jump += n % 2
        n = int(n / 2)

        if n == 1:
            jump += 1

    return jump