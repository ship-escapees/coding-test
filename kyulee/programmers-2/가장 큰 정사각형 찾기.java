

public class 가장 큰 정사각형 찾기 {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length; // 표의 행 개수
        int m = board[0].length; // 표의 열 개수
        int[][] dp = new int[n][m]; // 각 칸에서 만들 수 있는 가장 큰 정사각형의 한 변 길이 저장

        // 첫 번째 행과 첫 번째 열 초기화
        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0]; // 첫 번째 열은 그대로 복사
            answer = Math.max(answer, dp[i][0]); // 현재 최대 정사각형 크기 업데이트
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = board[0][j]; // 첫 번째 행은 그대로 복사
            answer = Math.max(answer, dp[0][j]); // 현재 최대 정사각형 크기 업데이트
        }

        // dp 배열 업데이트
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) { // 현재 위치가 1인 경우
                    // 왼쪽 위, 왼쪽, 위쪽 위치에서 만들 수 있는 가장 큰 정사각형 한 변 길이를 비교하여
                    // 가장 작은 값을 선택하고 1을 더해 현재 위치에서 만들 수 있는 가장 큰 정사각형 한 변 길이 계산
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    answer = Math.max(answer, dp[i][j]); // 현재 최대 정사각형 크기 업데이트
                }
            }
        }

        return answer * answer; // 가장 큰 정사각형의 넓이 반환
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
//        int[][] board = {{0,0,1,1},{1,1,1,1}};
        int test = solution(board);
        System.out.println(test);

    }
}