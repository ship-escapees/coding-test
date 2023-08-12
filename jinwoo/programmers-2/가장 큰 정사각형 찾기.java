class Solution
{
    public int solution(int[][] board) {
        int answer = 0;
        //주어진 배열에서 첫번째 행과 첫번째 열에 1이 있는지 체크하기 위한 변수
        //아래의 반복문에서는 첫번째행과 첫번째열의 값을 비교해나가며 배열의 값을 바꾸기 때문에 두번째행과 두번째열부터 값을 바꿔나가고 있음.
        //따라서 첫번째행과 첫번째열에 1X1 크기의 정사각형이 있는지 별도로 체크
        boolean one = false;

        //첫번째행에서 1이 있는지 체크
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1) one = true;
        }
        //첫번째열에서 1이 있는지 체크
        if (one == false) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 1) one = true;
            }
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0)
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(board[i][j], answer);
            }
        }
        if (answer==0 && one==true) answer=1;
        return answer * answer;
    }
}