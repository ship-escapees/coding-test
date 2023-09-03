import math
def solution(n, k):
    answer = []
    k = k - 1                            # k번째는 1부터 시작이므로 -1

    result = [i for i in range(1, n+1)]

    for i in range(n):
        cnt = k // math.factorial(n-1)   # n번째 자리 idx (첫번쨰 자리 idx부터)
        answer.append(result.pop(cnt))

        k = k % math.factorial(n-1)      # n+1번째 자리 idx 구하기 위한 초기화
        n -= 1                           # n번째 idx 제외했으므로 경우의 수 제거
    print(answer)
n = 3
k = 5
solution(n, k)
