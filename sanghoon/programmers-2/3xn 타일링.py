def solution(n):
    answer = [1,3]
    mod = 1000000007
    cnt = 1
    if n % 2 == 1 :                 # 홀수일 경우 타일을 전부 채울 수 없으므로 0
        return 0

    for i in range(2, n, 2):        # 2부터 n까지 2씩 증가
        cnt += 1                    # 인덱스 번호는 순서대로 하기 위한 변수
        answer.append(((answer[cnt - 1] * 4) - (answer[cnt - 2])) % mod) # 규칙에 따른 점화식
    print(answer[n//2])
    return answer[n//2]             # n의 정수 몫
n = 10
solution(n)