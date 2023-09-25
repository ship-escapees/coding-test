def solution(s):
    answer = ""
    s = s.split(" ")
    for i in range(len(s)) :
        s[i] = s[i].capitalize()
        answer += s[i]
    answer = " ".join(s)
    return answer