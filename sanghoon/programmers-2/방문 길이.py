def solution(dirs):
    answer = 0
    x,y = 0,0
    result = set()

    for i in dirs :
        current_x, current_y = x,y
        if i == 'U' :
            current_y += 1
        elif i == 'D' :
            current_y -= 1
        elif i == 'R' :
            current_x += 1
        else :
            current_x -= 1

        if -5 <= current_x <= 5 and -5 <= current_y <= 5 :
            result.add((current_x,current_y,x,y))
            result.add((x,y,current_x,current_y))
            x,y = current_x, current_y
    return len(result)/2

dirs = "ULURRDLLU"
solution(dirs)