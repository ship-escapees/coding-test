import math
def solution(w,h):
    gcd = math.gcd(w, h)
    return w * h - (gcd * (w / gcd + h / gcd - 1))


w = 8
h = 12
solution(w,h)