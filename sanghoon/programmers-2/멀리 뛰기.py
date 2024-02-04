def solution(n):
    answer = []
    answer.append(1)
    answer.append(1)
    answer.append(2)

    for i in range(3, n + 1) :
        answer.append(answer[i-1] + answer[i-2])
    print(answer[n] % 1234567)
    return answer[n] % 1234567


n = 4
solution(n)