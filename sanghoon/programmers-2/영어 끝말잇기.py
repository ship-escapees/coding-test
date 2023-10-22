def solution(n, words):
    answer = []
    result = []
    cnt = 0
    for i in range(len(words)) :
        if i % n == 0 :
            cnt += 1
        if words[i] in result :
            answer.append(i%n+1)
            answer.append(cnt)
            break
        else :
            if result and result[-1][-1] != words[i][0]:
                answer.append(i % n + 1)
                answer.append(cnt)
                break
            else :
                result.append(words[i])
    print(answer if answer else [0, 0])
    return 0


n = 2
words = ["hello", "one", "even", "never", "now", "world", "draw"]
solution(n, words)