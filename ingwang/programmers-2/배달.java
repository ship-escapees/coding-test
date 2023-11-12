import java.util.HashMap;
import java.util.Map;

class Solution20 {
    public static int solution20(int N, int[][] road, int K) {
        int answer = 0;
        int[][] a = new int[N][N];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == j) {
                    continue;
                }
                a[i][j] = 500001;
            }
        }
        for (int[] b : road) {
            if (a[b[0] - 1][b[1] - 1] < b[2]) {
                continue;
            }
            a[b[0] - 1][b[1] - 1] = b[2];
            a[b[1] - 1][b[0] - 1] = b[2];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (a[j][k] > a[j][i] + a[i][k])
                        a[j][k] = a[j][i] + a[i][k];
                }
            }
        }

        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
        System.out.println(solution20(5, a, 3));
    }
}
