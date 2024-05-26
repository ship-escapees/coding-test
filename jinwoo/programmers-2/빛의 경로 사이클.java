import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // 방향을 나타내는 배열 (상, 우, 하, 좌)
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public List<Integer> solution(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        boolean[][][] visited = new boolean[rows][cols][4]; // 각 셀의 4방향 방문 여부

        List<Integer> cycleLengths = new ArrayList<>();

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[x][y][d]) {
                        int cycleLength = findCycleLength(grid, visited, x, y, d);
                        cycleLengths.add(cycleLength);
                    }
                }
            }
        }

        Collections.sort(cycleLengths);
        return cycleLengths;
    }

    private int findCycleLength(String[] grid, boolean[][][] visited, int startX, int startY, int startDir) {
        int rows = grid.length;
        int cols = grid[0].length();
        int x = startX, y = startY, d = startDir;
        int length = 0;

        while (!visited[x][y][d]) {
            visited[x][y][d] = true;
            length++;

            // 현재 방향에 따라 다음 위치 계산
            x = (x + dx[d] + rows) % rows;
            y = (y + dy[d] + cols) % cols;

            // 현재 셀에서의 이동 방향 결정
            char cell = grid[x].charAt(y);
            if (cell == 'L') {
                d = (d + 3) % 4; // 좌회전
            } else if (cell == 'R') {
                d = (d + 1) % 4; // 우회전
            }
        }

        return length;
    }

}