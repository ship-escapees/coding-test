def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1) :
        cnt = 1
        result = ''
        previous = s[:i]
        print(previous)
        for j in range(i, len(s), i) :
            if previous == s[j:j+i] :
                cnt += 1
            else :
                result += str(cnt) + previous if cnt >= 2 else previous
                previous = s[j:j+i]
                cnt = 1
        result += str(cnt) + previous if cnt >= 2 else previous
        answer = min(answer, len(result))

    return answer

s = "aabbaccc"
solution(s)