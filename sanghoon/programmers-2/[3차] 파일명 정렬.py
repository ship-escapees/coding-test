import re
def solution(files):
    answer = []
    for file in files :
        head,number,tail = "", "", ""
        check = False

        for i in range(len(file)) :
            if not file[i].isdigit() :
                if check :
                    tail += file[i]
                else :
                    head += file[i]
            else :
                check = True
                number += file[i]
        print("head ", head)
        print("number ", number)
        print("tail ", tail)
        answer.append((head,number,tail))
    answer.sort(key=lambda x: (x[0].lower(), int(x[1])))
    answer = [''.join(value) for value in answer]
    print(answer)

    return answer

files = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
solution(files)