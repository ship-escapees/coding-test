from collections import deque
def solution(priorities, location):
    queue = []
    for process in enumerate(priorities) :     # index, 값 형태로 만들기
        queue.append(process)

    answer = 0
    while True:
        current = queue.pop(0)                      # 현재 프로세스에 올라간 인덱스, 값
        if any(current[1] < q[1] for q in queue):   # 현재 프로세스 우선순위보다 높은 우선 순위 찾기
            queue.append(current)                   # 제일 뒤 후순위로 보냄
        else:
            answer += 1                             # 카운트 시작
            if current[0] == location:              # index와 동일한 location 일 경우
                return answer

priorities = [1, 1, 9, 1, 1, 1]
location = 0
solution(priorities, location)