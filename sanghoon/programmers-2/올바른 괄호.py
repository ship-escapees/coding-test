def solution(s):
    cnt = 0
    for i in s:
        if i == "(":
            cnt += 1
        elif i == ")":
            cnt -= 1

        if cnt < 0:
            return False
            break

    if cnt == 0:
        return True
    else:
        return False
s = "(()("
solution(s)
