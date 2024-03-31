public class 삼각달팽이 {
    class Solution {
        // 아래, 오른쪽, 왼쪽 위
        static final int[] dx = {0, 1, -1};
        static final int[] dy = {1, 0, -1};

        public int[] solution(int n) {
            int[][] answer = new int[n][n];

            int c = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            while(true){
                answer[y][x] = c++;

                int nx = x + dx[d];
                int ny = y + dy[d];

                if ( nx == n || ny == n || nx == -1 || ny == -1 || answer[ny][nx] != 0){
                    d = (d+1) % 3;
                    nx = x + dx[d];
                    ny = y + dy[d];

                    if ( nx == n || ny == n || nx == -1 || ny == -1 || answer[ny][nx] != 0) break;
                }

                x = nx;
                y = ny;
            }

            int[] result = new int[c-1];
            int idx = 0;
            for (int i = 0; i < n; i++){
                for (int j=0; j <= i; j++){
                    result[idx++] = answer[i][j];
                }
            }

            return result;
        }
    }
}
