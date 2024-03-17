def solution(p):
    answer = ''
    if p == "" :        # 비었으면 빈 문자열 리턴
        return answer

    u, v = p, ""        # 2 - 3
    for i in range(1, len(p) + 1):
        if balance(p[:i]):
            u = p[:i]
            v = p[i:]
            break

    if correct(u):      # 4
        answer = u + solution(v)
    else:
        answer = "("
        answer += solution(v)
        answer += ")"
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == "(":
                u[i] = ")"
            else:
                u[i] = "("
        answer += "".join(u)

    return answer



def balance(p): # 균형잡힌 괄호
    return p.count("(") == p.count(")")

def correct(p): # 올바른 괄호 문자열
    cnt = 0
    for i in p:
        if i == "(" :
            cnt += 1
        else :
            if cnt == 0:
                return False
            cnt -= 1
    return True

p = "(()())()"
solution(p)