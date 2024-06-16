class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];

        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            int mx = h+x[i];
            int my = w+y[i];
            if (mx < 0 || my < 0 || mx > board.length-1 || my > board.length-1) continue;
            String targetColor = board[mx][my];
            if(color.equals(targetColor)) answer++;
        }
        
        return answer;
    }
}
