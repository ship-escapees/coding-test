def solution(s):
    stack = []
    for i in range(len(s)):
        if len(stack) == 0 or stack[-1] != s[i]:
            stack.append(s[i])
        else:
            stack.pop()

    return 1 if len(stack) == 0 else 0

s = "baabaa"
solution(s)
