from itertools import permutations
def solution(numbers):
    answer = 0
    num = set()

    for i in range(1, len(numbers) + 1) :
        num |= set(map(''.join, permutations(numbers, i)))
    num = set(map(int, num))

    for j in num :
        if isprime(j) :
            answer += 1
    print(answer)
    return answer
def isprime(N):
    if N == 0 or N == 1:
        return False
    if N == 2 or N == 3:
        return True
    for i in range(2, int(N ** 0.5) + 1):
        if N % i == 0:
            return False
    return True


numbers = "17"
solution(numbers)