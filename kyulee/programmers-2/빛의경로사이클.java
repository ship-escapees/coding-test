import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 빛의경로사이클 {
    public class Solution {
        // 방향 배열 (상, 우, 하, 좌)
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};

        public List<Integer> solution(String[] grid) {
            int n = grid.length;
            int m = grid[0].length();
            boolean[][][] visited = new boolean[n][m][4]; // 각 칸의 4방향 방문 여부
            List<Integer> result = new ArrayList<>();

            // 모든 칸에 대해 4개의 방향에서 시작
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    for (int d = 0; d < 4; d++) {
                        if (!visited[x][y][d]) {
                            result.add(findCycleLength(grid, visited, x, y, d));
                        }
                    }
                }
            }

            Collections.sort(result);
            return result;
        }

        private int findCycleLength(String[] grid, boolean[][][] visited, int startX, int startY, int startD) {
            int x = startX;
            int y = startY;
            int d = startD;
            int n = grid.length;
            int m = grid[0].length();
            int length = 0;

            while (!visited[x][y][d]) {
                visited[x][y][d] = true;
                length++;

                // 다음 칸으로 이동
                if (grid[x].charAt(y) == 'L') {
                    d = (d + 3) % 4; // 좌회전
                } else if (grid[x].charAt(y) == 'R') {
                    d = (d + 1) % 4; // 우회전
                }

                x = (x + dx[d] + n) % n; // 행이 격자를 벗어나면 반대쪽 끝으로 이동
                y = (y + dy[d] + m) % m; // 열이 격자를 벗어나면 반대쪽 끝으로 이동
            }

            return length;
        }
    }
}
