from collections import deque

def solution(queue1, queue2):
    answer = 0
    q1 = deque(queue1)
    q2 = deque(queue2)

    # 무한으로 돌때를 대비한 한계치 설정 : 모든 원소가 한쪽에 모두 몰렸다가 다시 다른 쪽으로 이동한 케이스까지 생각한 한계치
    limit = len(q1) * 3

    # 양쪽의 합 계산
    sum1 = sum(q1)
    sum2 = sum(q2)

    # 같은 때까지 또는 한계치 도달까지 반복
    while sum1 != sum2:
        # 큰쪽에서 첫번째 원소가 작은쪽으로 이동시키며 같아지도록 조정
        if sum1 > sum2:
            num = q1.popleft()
            q2.append(num)
            sum1 -= num
            sum2 += num
        elif sum1 < sum2:
            num = q2.popleft()
            q1.append(num)
            sum1 += num
            sum2 -= num
        answer += 1

        if answer == limit:
            return -1

    return answer