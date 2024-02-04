def solution(land):
    answer = 0

    # 한 행에 한칸만, 그리고 다음 행을 넘어갈때 같은 열을 밟을 수 없다는 사항이 중요
    # (1,0)위치를 예로 들면 (0,1)(0,2)(0,3) 위치에서만 (1,0)은 밟을 수 있고 (0,0)은 (1,0)을 밟을 수 없음
    # 각 위치의 다양한 경우의 수 따져 가장 큰 수를 찾는 케이스니 DP 사용

    # land의 DP 값을 저장하도록 2차원 배열 정의
    dp = [[0 for j in range(len(land[0]))] for i in range(len(land))]

    # 0행은 먼저 저장 for문은 1행부터 시작
    dp[0] = land[0]

    for i in range(1, len(dp)):  # 행
        for j in range(len(dp[0])):  # 열
            # 같은 열인 것을 제외하는 방법 (j열만 제외하고 배열 붙이기)
            dp[i][j] = land[i][j] + max(dp[i - 1][:j] + dp[i - 1][j + 1:])

    return max(dp[-1])  # 마지막 열에서 가장 큰 값 출력