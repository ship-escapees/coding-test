def solution(arr):
    answer = [0, 0]
    length = len(arr)

    def compression(a, b, l):
        start = arr[a][b]
        for i in range(a, a + l):
            for j in range(b, b + l):
                if arr[i][j] != start:
                    l = l // 2
                    compression(a, b, l)
                    compression(a, b + l, l)
                    compression(a + l, b, l)
                    compression(a + l, b + l, l)
                    return

        answer[start] += 1

    compression(0, 0, length)

    return answer

arr = [[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]
solution(arr)