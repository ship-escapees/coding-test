public class 이웃한칸 {
    class Solution {
        public int solution(String[][] board, int h, int w) {
            // 보드의 크기
            int n = board.length;

            // 같은 색으로 칠해진 칸의 개수를 저장할 변수
            int count = 0;

            // h와 w의 변화량을 저장할 배열
            int[] dh = {0, 1, -1, 0};
            int[] dw = {1, 0, 0, -1};

            // 현재 칸의 색깔
            String color = board[h][w];

            // 4방향을 검사
            for (int i = 0; i < 4; i++) {
                int h_check = h + dh[i];
                int w_check = w + dw[i];

                // 인접한 칸이 보드의 범위를 벗어나지 않는지 확인
                if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                    // 같은 색이면 count 증가
                    if (board[h][w].equals(board[h_check][w_check])) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
