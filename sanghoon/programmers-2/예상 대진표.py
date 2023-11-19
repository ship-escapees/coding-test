def solution(n,a,b):
    answer = 0
    while True :
        answer += 1

        a = (a + 1) // 2
        b = (b + 1) // 2

        if a == b :
            break
    print(answer)

n = 8
a = 4
b = 7
solution(n,a,b)