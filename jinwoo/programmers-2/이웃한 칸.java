public class Solution {
    public static int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        // h와 w의 변화량을 저장하는 배열
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        // 현재 칸의 색깔
        String color = board[h][w];
        
        // 4방향을 체크
        for (int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            // 경계를 벗어나지 않는지 확인
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 같은 색깔인지 확인
                if (board[h_check][w_check].equals(color)) {
                    count++;
                }
            }
        }
        
        return count;
    }

}
