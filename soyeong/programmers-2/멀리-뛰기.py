def solution(n):
    # 이것도 DP 피보나치 수열

    # 경우의 수 저장할 배열 생성
    n_list = [0] * n

    for i in range(n):
        # 0열과 1열은 예외에 해당하므로 미리 저장
        if i == 0:
            n_list[i] = 1
        elif i == 1:
            n_list[i] = 2
        else:
            # 여기서부터가 반복
            n_list[i] = n_list[i - 1] + n_list[i - 2]

    return n_list[-1] % 1234567