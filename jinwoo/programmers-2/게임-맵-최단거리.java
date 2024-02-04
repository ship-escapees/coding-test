import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1, -1, 0, 0}; // 동, 서, 남, 북 방향으로 이동
        int[] dy = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1)); // 시작 위치 (0, 0)과 이동 횟수 1을 큐에 삽입
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            int count = p.count;

            if (x == m - 1 && y == n - 1) { // 상대 팀 진영에 도착한 경우
                return count;
            }

            for (int i = 0; i < 4; i++) { // 동, 서, 남, 북 방향으로 이동
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny, count + 1));
                }
            }
        }

        return -1; // 상대 팀 진영에 도착할 수 없는 경우
    }
}