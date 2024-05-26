from itertools import combinations
from bisect import bisect_left  # 이분 검색 라이브러리

def solution(info, query):
    # ----------- info 정리
    info_dict = {}
    for one in info:
        info_one_list = one.split(" ")
        info_key = info_one_list[:-1]  # 점수 외 지원작성 요소
        info_value = info_one_list[-1]  # 점수 부분

        # 점수 외 지원작성 요소로 1,2,3,4 짝의 모든 조합을 만들어 dictionary형태로 정리
        # 왜 여러개의 조합을 만들까? 일부 조건이 없어 - 처리된 경우에도 빠르게 조건을 매칭하지 위해서
        for i in range(5):  # 왜 조합이 0경우도 포함할까? 모든 조건이 - 인 경우도 체크해야 하니까
            for comb_one in combinations(info_key, i):
                temp = ''.join(comb_one)  # 조합을 문자열로 합침
                if temp in info_dict:
                    # 기존 dict에 있는 조합이면 해당 키에 점수만 더 추가
                    # 같은 키에 여러 점수를 넣는 것도 해당 조건을 만족하는 경우 점수만을 빠르게 체크하기 위해서
                    info_dict[temp].append(int(info_value))
                else:  # 기존 dict에 없는 조합이면 키(조합)와 값(점수) 쌍을 추가
                    info_dict[temp] = [int(info_value)]

    # 점수 값을 빠르게 체크하기 위해 정렬
    for i in info_dict:
        info_dict[i].sort()

    # ----------- 분류 과정
    answer = []
    for one in query:

        # 조건 정리
        query_one_list = one.replace(" and ", " ").split(" ")
        query_key = query_one_list[:-1]
        query_value = query_one_list[-1]

        while '-' in query_key:
            query_key.remove('-')

        q_temp = ''.join(query_key)  # 조건 key를 문자열로 합침

        # 명수 체크
        if q_temp in info_dict:  # 조건 key가 info_dict에 일치하는게 있다면
            scores = info_dict[q_temp]  # 해당키의 점수 배열을 가져오고

            # 효율성을 위해 원하는 점수 찾는 방식을 이분 탐색으로 사용
            if scores:
                enter = bisect_left(scores, int(query_value))
                answer.append(len(scores) - enter)
        else:  # 맞는 조건이 없으므로 0명
            answer.append(0)

    return answer