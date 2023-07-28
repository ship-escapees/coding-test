def solution(n):
    list = [10,20,70]
    cnt = 1
    answer = 0
    index = 0
    while 3 * cnt < n :
        cnt = cnt + 1
        if index == 3:
            index = 0
        answer = answer + list[index]
        index = index + 1
    answer = answer - list[index-1]
    print("cnt", cnt -1)
    if cnt > 1:
        answer = answer + 10
    print("answer", answer)

    last = n%3
    if last == 0 :
        last = 4
    answer = answer + last
    print("n%3", n%3)
    print("정답",answer)
n = 30
solution(n)