import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 교점에별만들기 {
    public class Solution {
        public String[] solution(int[][] line) {
            Set<Point> points = new HashSet<>();

            // 모든 직선 쌍의 교점을 구한다.
            int n = line.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int[] line1 = line[i];
                    int[] line2 = line[j];
                    Point intersection = getIntersection(line1, line2);
                    if (intersection != null) {
                        points.add(intersection);
                    }
                }
            }

            // 정수 교점의 x, y 좌표의 최소 및 최대값을 구한다.
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
            for (Point p : points) {
                minX = Math.min(minX, p.x);
                maxX = Math.max(maxX, p.x);
                minY = Math.min(minY, p.y);
                maxY = Math.max(maxY, p.y);
            }

            // 결과를 그리기 위한 2D 배열 초기화
            int width = maxX - minX + 1;
            int height = maxY - minY + 1;
            char[][] grid = new char[height][width];
            for (char[] row : grid) {
                Arrays.fill(row, '.');
            }

            // 별을 그린다.
            for (Point p : points) {
                int x = p.x - minX;
                int y = maxY - p.y; // 배열에서 위로 가면 y가 감소하므로
                grid[y][x] = '*';
            }

            // 결과를 문자열 배열로 변환
            String[] result = new String[height];
            for (int i = 0; i < height; i++) {
                result[i] = new String(grid[i]);
            }

            return result;
        }

        private Point getIntersection(int[] line1, int[] line2) {
            long A = line1[0], B = line1[1], E = line1[2];
            long C = line2[0], D = line2[1], F = line2[2];
            long denominator = A * D - B * C;

            if (denominator == 0) {
                return null; // 평행하거나 일치하는 직선
            }

            long xNumerator = B * F - E * D;
            long yNumerator = E * C - A * F;

            if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
                return null; // 교점이 정수 좌표가 아님
            }

            long x = xNumerator / denominator;
            long y = yNumerator / denominator;

            return new Point((int)x, (int)y);
        }

        private static class Point {
            int x, y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Point point = (Point) obj;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}
