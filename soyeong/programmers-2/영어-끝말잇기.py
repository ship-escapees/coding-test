def solution(n, words):
    # words는 끝말잇기의 진행상황
    # 1부터 시작하는 이유는 번호가 1부터 시작하여 인덱스 자체를 번호로 사용하기 위함
    for i in range(1, len(words)):
        # 이번 i번째 워드의 첫 알파벳이 이전 번째의 워드의 마지막 알파벳과 다르다면 true
        # or
        # i번째 인덱스 이전에 같은 word가 이미 나왔었다면 true
        if words[i][0] != words[i - 1][-1] or words[i] in words[:i]:
            # 그 순서를 인원수 대로 나눈 +1 탈락하는 사람 번호
            # 그 순서를 인원수 대로 나눈 몫에서 +1 한게 그 사람의 몇번째 차례에서 떨어지는지 숫자
            return [(i % n) + 1, (i // n) + 1]  # 탈락하는 사람 번호, 탈락하는 사람 자신의 몇번째 차례
    else:
        # 아무것도 해당 안되면 바로 탈락!
        return [0, 0]