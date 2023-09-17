def solution(n):
    def hanoi(n, first, last, mid):
        if n == 1:
            answer.append([first, last])
            return
        hanoi(n - 1, first, mid, last)
        answer.append([first, last])
        hanoi(n - 1, mid, last, first)

    answer = []
    hanoi(n, 1, 3, 2)
    print(answer)
    return answer
n = 3

solution(n)