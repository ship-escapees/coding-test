def solution(brown, yellow):
    # 가로 a, 세로 b
    # Brown = 2a + 2b - 4
    # Yellow = (a-2)(b-2) = ab - (2a + 2b - 4)
    # Yellow + Brown = ab

    answer = []
    num_ab = brown + yellow
    for a in range(1, num_ab + 1):
        if num_ab % a == 0:
            b = num_ab / a
            if (a >= b) and ((2 * a + 2 * b - 4) == brown):
                return [a, b]
    return answer