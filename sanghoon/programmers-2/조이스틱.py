def solution(name):
    answer = 0
    min_move = len(name) - 1
    for i, char in enumerate(name) :
        up = ord(char) - ord('A')
        down = ord('Z') - ord(char) + 1
        answer += min(up, down)

        next = i + 1
        while next < len(name) and name[next] == 'A' :
            next += 1
        min_move = min([min_move, 2 *i + len(name) - next, i + 2 * (len(name) - next)])
    answer += min_move
    print(answer)
name = "JAN"
solution(name)