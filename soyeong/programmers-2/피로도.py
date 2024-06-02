from itertools import permutations

def solution(k, dungeons):
    answer = 0

    # 모든 던전을 다양한 순서로 돌아보고 가장 많은 던전을 돌아보는 케이스를 반환 (순열)
    # 최대 던전이 8개 밖에 안되서 완전 탐색이 가능한 케이스
    for permOne in permutations(range(len(dungeons)), len(dungeons)):
        fatigue = k
        dCnt = 0

        for i in permOne:
            minFatigue, useFatigue = dungeons[i]
            # 현재 피로도가 던전이 요구하는 최소 피로도 보다 크면
            if fatigue >= minFatigue:
                # 이번 케이스의 던전 방문 수 갱신
                dCnt += 1
                # 현재 피로도에서 소모 피로도 차감
                fatigue -= useFatigue

        # 모든 케이스 중 가장 던전 방문 수가 큰 케이스를 answer에
        answer = max(answer, dCnt)

    return answer