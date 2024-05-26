import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        // 교점을 저장할 리스트
        List<int[]> points = new ArrayList<>();
        
        // 모든 직선 쌍을 비교하여 교점을 구함
        int n = line.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[i][2];
                long D = line[j][0];
                long E = line[j][1];
                long F = line[j][2];
                
                long denominator = A * E - B * D;
                if (denominator == 0) continue; // 평행하거나 겹치는 직선
                
                long xNumerator = B * F - C * E;
                long yNumerator = C * D - A * F;
                
                if (xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                    int x = (int) (xNumerator / denominator);
                    int y = (int) (yNumerator / denominator);
                    points.add(new int[]{x, y});
                }
            }
        }
        
        // 최소 및 최대 x, y 좌표를 구함
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }
        
        // 격자판 크기 계산
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        
        // 격자판 생성
        char[][] grid = new char[height][width];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        
        // 별을 그리기
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int adjustedX = x - minX;
            int adjustedY = maxY - y;
            grid[adjustedY][adjustedX] = '*';
        }
        
        // 결과 문자열 배열로 변환
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }

}
