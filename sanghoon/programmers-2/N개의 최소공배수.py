def solution(arr):
    answer = max(arr)
    cnt = 0
    while cnt != len(arr):
        cnt = 0
        for i in arr :
            if answer % i == 0 :
                cnt += 1
            else :
                answer += 1
                break
    return answer

arr = [1,2,3]
solution(arr)