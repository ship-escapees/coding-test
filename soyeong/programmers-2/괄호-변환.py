def is_balanced(s):
    check = 0
    for i in s:
        if i == '(':
            check += 1
        else:
            check -= 1
    if check == 0:
        return True
    else:
        return False


def is_collect(s):
    l = []
    for i in s:
        if i == '(':
            l.append(i)
        else:
            # ')'를 붙여야하는 상황에서 배열이 비어있다면 올바른 괄호 아님
            if len(l) == 0:
                return False
            else:
                l.pop()

    if len(l) == 0:
        return True
    else:
        return False


def solution(p):
    answer = ''
    u = ""
    v = ""

    # 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. + 만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
    if len(p) == 0 or is_collect(p):
        return p

    # 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    # 짝을 맞춰보기위해 2개씩 괄호를 넣어서 여는괄호 닫는 괄호 개수를 판단하여 u,v 나눔
    for i in range(2, len(p) + 1, 2):
        if is_balanced(p[0:i]):
            u = p[:i]
            v = p[i:]
            break

    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    if is_collect(u):
        # 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        answer += u + solution(v)
    else:
        # 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        answer = '('
        # 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        answer += solution(v)
        # 4-3. ')'를 다시 붙입니다.
        answer += ')'

        # 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 "괄호 방향을 뒤집어서" 뒤에 붙입니다.
        for i in u[1:-1]:
            if (i == '('):
                answer += ')'
            else:
                answer += '('

    # 4-5. 생성된 문자열을 반환합니다.
    return answer