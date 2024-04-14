def solution(s):
    # (s길이-1)번 만큼 괄호를 회전시켜보면서 올바른 괄호문자열이 될수 있는 케이스가 몇개나 되는지 판단하는 문제

    # 짝 판별 문제는 보통 stack으로
    answer = 0
    # 괄호짝 위한 리스트
    bracket = ['(', ')', '[', ']', '{', '}']
    # 문자열을 리스트로 변형
    s_list = list(s)
    for i in range(len(s)):
        # i = 0은 회전이 없는 경우를 판단하기 때문에 회전 처리 통과
        if i != 0:
            s_list.append(s_list.pop(0))

        # ---- 여기서 부터 올바른 괄호 문자 판단
        stack = []  # 괄호 짝을 위한 stack
        for one in s_list:
            # stack에 괄호하나 push
            stack.append(one)
            stack_len = len(stack)
            # 괄호짝은 최소 2개 부터 판단이 가능하므로 2개 이상일때 부터
            if stack_len >= 2:
                # 괄호짝 위한 리스트로 부터 괄호를 가져와
                # stack top(stack배열의 마지막2개)이 올바른 괄호 문자열이면 stack에서 제거
                for x in range(0, len(bracket), 2):
                    if stack[stack_len - 2:stack_len] == bracket[x:x + 2]:
                        stack = stack[:stack_len - 2]

        # stack이 모두 비었다면 모두 올바른 괄호 문자열이 됬다는 의미로 answer 카운트
        if len(stack) == 0:
            answer += 1

    return answer