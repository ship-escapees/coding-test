def solution(land):
    for i in range(1, len(land)) :                              # 0행은 더하지 않음
        for j in range(4) :                                     # 열의 갯수는 4개 고정
            land[i][j] += max(land[i-1][:j] + land[i-1][j+1:])  # 이전 행의 같은 열의 값을 제외하고 계속 더해나감
                                                                # 이전 행의 같은 열 제외 위해 이전, 이후만 슬라이싱
    print(max(land[len(land)-1]))                               # 마지막 행의 최대값이 최고점
    return max(land[len(land)-1])

land = [[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]
solution(land)