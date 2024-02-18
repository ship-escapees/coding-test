from collections import deque
def solution(people, limit):
    answer = 0
    people = deque(sorted(people, reverse=True))
    print(people)

    while len(people) > 0 :
        if len(people) == 1 :
            answer += 1
            break
        if people[0] + people[-1] <= limit :
            answer += 1
            people.pop()
            people.popleft()
        else :
            answer += 1
            people.popleft()
    return answer

people = [70, 80, 50]
limit = 100
solution(people, limit)