def solution(s):
    answer = 0
    s_list = list(s)
    if len(s) % 2 == 0 :
        for i in range(len(s)) :
            if i == 0 :
                s = ''.join(s_list)
            else :
                s_list.append(s_list[0])
                del s_list[0]
                s = ''.join(s_list)
            while '[]' in s or '()' in s or '{}' in s:
                if '[]' in s:
                    s = s.replace('[]', '')
                if '()' in s:
                    s = s.replace('()', '')
                if '{}' in s:
                    s = s.replace('{}', '')
            if s == '' :
                answer += 1
    else :
        return 0
    return answer