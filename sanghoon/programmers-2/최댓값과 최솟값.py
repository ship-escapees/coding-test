def solution(s):
    s = s.split()
    for i in range(len(s)) :
        s[i] = int(s[i])
    # print(str(min(s)) + " " + str(max(s)))
    return str(min(s)) + " " + str(max(s))

s = "1 2 3 4"
solution(s)