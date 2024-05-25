def solution(n, left, right):
    # i행 i열 까지 채우라는 것은 좌표로 치면
    # 1은     (1,1) 까지
    # 2이면   (1,2)(2,1)(2,2) 까지
    # 3이면   (1,3)(2,3)(3,1)(3,2)(3,3) 처럼 채우라는 것

    # 다차원 배열을 만들고 그걸 다시 1차원 배열로 만드는 방식은 시간 초과 발생
    # 1차원 배열이 되었을 때의 값을 예상해서 left와 right 인덱스의 값을 미리 뽑는 방식

    answer = []

    # right 인덱스 1일 경우만 예외 처리
    if right == 1:
        answer.append(1)
    else:
        for i in range(left, right + 1):

            col = (i % n) + 1
            row = int(i / n) + 1

            # 열이 행보다 크다면 열, 반대면 행을 추가
            if col > row:
                answer.append(col)
            else:
                answer.append(row)

    return answer