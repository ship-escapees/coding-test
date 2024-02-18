def solution(msg):
    answer = []
    d = dict()
    print(d)

    for c in range(ord('A'), ord('Z') + 1) :    # A-Z 색인 번호 초기화
        d[chr(c)] = c - ord('A') + 1
    idx = 27                                    # 등록될 색인 번호 초기화
    start, end = 0,1                            # 시작, 끝

    while end < len(msg) + 1 :
        s = msg[start:end]
        if s in d :                             # 등록된 문자열 확인
            end += 1
        else :
            answer.append(d[s[:-1]])            # 해당하는 색인 번호 저장
            d[s] = idx                          # 등록될 새로운 문자, 색인번호 저장
            idx += 1                            # 등록될 색인 번호 증가
            start = end - 1                     # 시작 번호 증가

    answer.append(d[s])
    print(answer)
    return answer

msg = "KAKAO"
solution(msg)