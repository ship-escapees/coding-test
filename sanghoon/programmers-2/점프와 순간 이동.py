def solution(n):
    ans = 0

    while n > 0 :
        if n % 2 == 0 :
            n = n//2
        else :
            n -= 1
            ans += 1
    print(ans)
n = 6
solution(n)