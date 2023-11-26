def solution(n):
    answer = 0

    for i in range(n + 1):
        cnt = 0
        while cnt != n:
            i += 1
            cnt += i

            if cnt == n:
                answer += 1
                break
            elif cnt > n:
                break
    return answer