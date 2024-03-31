def solution(arr):
    # 다차원 배열을 사각형형태로 했을때 큰 사각형에서 작은사각형으로 계속 4등분으로 나눠가며 압축시도
    answer = [0, 0]
    N = len(arr)  # 행, 열 n의 길이

    def comp(x, y, n):
        num = arr[x][y]  # 네모안 숫자중 첫번째 숫자를 판단의 기준으로 설정
        for i in range(x, x + n):
            for j in range(y, y + n):
                if arr[i][j] != num:  # 네모안 숫자들 중 한개라도 num과 다르면 이 네모는 압축불가
                    # 네모안 숫자들 중 다른 숫자가 있으므로 분할
                    divN = n // 2  # 정사각형 4개로 나누기 위해 이전 길이를 2로 나눔
                    comp(x, y, divN)  # 좌측,위 사각형 판단
                    comp(x, y + divN, divN)  # 우측,위 사각형 판단
                    comp(x + divN, y, divN)  # 좌측,아래 사각형 판단
                    comp(x + divN, y + divN, divN)  # 우측,아래 사각형 판단
                    return

        # 조건을 통과했다면 압축가능하므로 해당 숫자를 하나로 압축되며
        # 압축되지 못한 1개짜리가 된다면 arr[i][j] = num은 무조건 같은수 밖에 없으므로 압축되지 못한 숫자는 전부 여기서 자동 count됨
        answer[num] += 1

    comp(0, 0, N)
    return answer