from collections import Counter
def solution(clothes):

    clothes_count = {}

    for item in clothes :                       # 의상 종류 별 갯수 딕셔너리 화
        item_type = item[1]
        clothes_count[item_type] = clothes_count.get(item_type,0) + 1
    answer = 1
    for i in clothes_count.values() :           # 의상 가지수에 +1해서 거듭제곱
        answer *= (i+1)
    print(answer-1)
    return answer - 1                           # 아무것도 입지 않은 경우 -1
clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
solution(clothes)