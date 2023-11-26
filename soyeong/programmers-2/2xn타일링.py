def solution(n):
    # 1 = 1
    # 2 = 2
    # 3 = 3
    # 4 = 5
    # 5 = 8
    # 6 = 13
    # n = [n-1] + [n-2]

    # 동적계획법 DP 사용방식
    DP = [0 for i in range(n)]                          # 이전 경우 수 기록용 배열

    DP[0] = 1
    DP[1] = 2

    for i in range(2, n):                               # 방식에 들어가지 못하는 0,1 인덱스 제외 그 이후부터
        DP[i] = (DP[i - 1] + DP[i - 2]) % 1000000007    # 경우의 수 많아져 overflow 되는 것 방지

    return DP[n - 1]                                    # 마지막 경우의 수 출력