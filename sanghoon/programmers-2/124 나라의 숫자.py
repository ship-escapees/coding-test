def solution(n):
    answer = ""
    list = ['4','1','2']
    while n :
        if n % 3 == 0 :
            answer += list[n%3]
            n = n//3 - 1
        else:
            answer += list[n%3]
            n = n//3
    print(answer[::-1])
n = 3
solution(n)
