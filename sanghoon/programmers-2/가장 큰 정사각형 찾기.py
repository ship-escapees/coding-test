def solution(board):
    idx1 = len(board)       #표의 가로행
    idx2 = len(board[0])    #표의 세로행

    for i in range(idx1):
        for j in range(idx2) :
            if i == 0 or j == 0 :   # 첫번째 가로, 세로행의 왼쪽은 없으므로 continue
                continue

            if board[i][j] == 0 :   # 0일 경우 정사각형이 될 수 없으므로 continue
                continue
            elif board[i][j] != 0:  # 0이 아닐 경우 왼쪽, 위쪽, 대각선에 0이 없다면 2x2의 정사각형을 만들 수 있고
                                    # 정사각형 내의 자기자신을 제외한 최소값에 +1을 해 구할 수 있는 최대 크기의
                                    # 가로 세로 길이를 구할 수 있음.
                minimum = min(board[i-1][j], board[i][j-1], board[i-1][j-1]) # 왼쪽, 위쪽, 대각선의 최소값
                board[i][j] = minimum + 1   # 최소값에서 + 1
    print(board)
    print(max(map(max, board)) ** 2)

    return max(map(max, board)) ** 2

board = [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]
solution(board)
