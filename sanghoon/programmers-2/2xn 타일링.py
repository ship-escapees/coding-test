def solution(n):
    answer = list(range(1, n+1))        # 첫째 자리 1부터, 마지막 수 공간 확보
    for i in range(2, n):               # 0,1 인덱스는 1,2 고정
        answer[i] = answer[i-2] + answer[i-1] % 1000000007 # 나눠질때마다 나눈 나머지
    print(answer[n-1])
    return answer[n-1]

n = 4
solution(n)