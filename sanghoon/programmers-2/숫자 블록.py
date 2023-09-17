def solution(begin, end):
    answer = []
    for i in range(begin, end + 1):
        if i == 1 :
            answer.append(0)
        else :
            answer.append(find_value(i))
    print(answer)
def find_value(num):                        # 약수 구하는 함수
    value = 1                               # 약수가 없으면 1을 반환
    for i in range(2, int(num**(0.5))+1):   # 1의 경우는 제외한 제곱근까지 숫자 확인
        if num % i == 0:                    # 약수일 경우 value에 저장
            value = i
            if (num // i) <= 10000000:      # 천만까지만 경우의 수 따짐
                return num // i
    return value
solution(begin=1, end=10)