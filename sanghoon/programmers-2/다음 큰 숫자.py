def solution(n):
    length1 = len(format(n, 'b').replace('0', ''))  # 자연수 n의 1 갯수
    cnt = 0                                                     # 다음 큰 숫자 찾기 위한 cnt
    while n:
        cnt += 1
        length2 = len(format(n + cnt, 'b').replace('0', '')) # 자연수 n 다음의 큰 숫자 찾기
        if length1 == length2:                                           # n과 1의 갯수가 같을때
            print(n + cnt)
            return n + cnt
        else:
            continue

n = 78
solution(n)