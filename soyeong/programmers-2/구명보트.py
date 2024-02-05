from collections import deque

def solution(people, limit):
    answer = 0
    # 무거운 사람과 가벼운 사람을 같이 많이 구출하는 게 포인트
    # 무거운 사람과 가벼운 사람을 무게를 더해 limit보다 적으면 둘다 구출, 아니면 무거운 사람만 구출
    # 오름차순으로 정렬, deque에 대입
    people = deque(sorted(people))  # deque로 안쓰고 했더니 효율성케이스1에서 시간초과 떠서 deque사용

    while len(people) > 1:
        if people[0] + people[-1] <= limit:
            people.pop()
            people.popleft()
            answer += 1
        else:
            people.pop()
            answer += 1

    if people:
        answer += 1

    return answer