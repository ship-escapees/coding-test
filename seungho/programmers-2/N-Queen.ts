/*
가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다.
 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.

예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.

체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때,
 n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.

제한사항
퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
n은 12이하의 자연수 입니다.

1. 재귀적으로 퀸을 특정 위치에 배치하는게 안전한지 확인

2. 안전하지 않다면 배치를 포기하고 다음 위치로 넘어감

3. 특정 행에 퀸을 배치할 수 없다면 이전 행으로 돌아가서 다른 위치에 퀸을 배치
*/

const nQueen = (n: number): number => {
    let count = 0;

    function isSafe(board: number[], row: number, col: number): boolean {
        for (let i = 0; i < row; i++) {
            if (board[i] === col || Math.abs(board[i] - col) === row - i) {
                return false;
            }
        }
        return true;
    }
    
    function placeQueen(board: number[], row: number) {
        if (row === n) {
            count++;
            return;
        }

        for (let col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                placeQueen(board, row + 1);
            }         
        }
    }

    placeQueen(new Array(n).fill(-1), 0);
    
    return count;
}
