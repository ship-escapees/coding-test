import java.util.*;

public class 행렬테두리회전하기 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            // 주어진 행렬 생성 및 초기화
            int[][] matrix = new int[rows][columns];
            int num = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = num++;
                }
            }

            // 결과를 담을 배열
            int[] result = new int[queries.length];

            // 각 회전에 대해 순회
            for (int i = 0; i < queries.length; i++) {
                // 회전을 적용하고, 회전된 테두리의 최솟값을 찾아 결과 배열에 추가
                result[i] = rotateAndFindMin(matrix, queries[i]);
            }

            return result;
        }

        // 주어진 행렬에서 테두리를 시계방향으로 회전하고, 회전된 테두리 중 최솟값을 반환하는 함수
        private int rotateAndFindMin(int[][] matrix, int[] query) {
            int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;

            // 상단 테두리
            int prev = matrix[x1][y1];
            int min = prev;
            for (int i = y1 + 1; i <= y2; i++) {
                min = Math.min(min, prev);
                int temp = matrix[x1][i];
                matrix[x1][i] = prev;
                prev = temp;
            }

            // 우측 테두리
            for (int i = x1 + 1; i <= x2; i++) {
                min = Math.min(min, prev);
                int temp = matrix[i][y2];
                matrix[i][y2] = prev;
                prev = temp;
            }

            // 하단 테두리
            for (int i = y2 - 1; i >= y1; i--) {
                min = Math.min(min, prev);
                int temp = matrix[x2][i];
                matrix[x2][i] = prev;
                prev = temp;
            }

            // 좌측 테두리
            for (int i = x2 - 1; i >= x1; i--) {
                min = Math.min(min, prev);
                int temp = matrix[i][y1];
                matrix[i][y1] = prev;
                prev = temp;
            }

            return min;
        }
    }
}
