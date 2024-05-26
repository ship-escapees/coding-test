answer = 0
def DFS(string, word):
    alphabets = ['A', 'E', 'I', 'O', 'U']
    global answer
    answer += 1

    # 단어를 찾았으면 return
    if string == word:
        return True

    # word 길이는 최대 5개 이므로 5개 길이가 됬는데 단어가 일치하지 않으면 false
    if len(string) == 5:
        return False

    for a in alphabets:
        if (DFS(string + a, word) == True):  # 알파벳하나를 더 붙여 재귀
            return True

def solution(word):
    global answer
    alphabets = ['A', 'E', 'I', 'O', 'U']

    for a in alphabets:
        if (DFS(a, word) == True):
            return answer