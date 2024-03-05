def solution(numbers, target):
    sup = [0]                   # numbers의 0번 인덱스 지정 위해

    for i in numbers:           # numbers의 양,음 모든 경의의 수 sup에 append
        sub = []
        for j in sup:
            sub.append(j + i)
            sub.append(j - i)
        sup = sub
    return sup.count(target)    # target과 동일한 수만 카운트

numbers = [4, 1, 2, 1]
target = 4
solution(numbers, target)	