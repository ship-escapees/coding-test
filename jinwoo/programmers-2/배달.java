import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        final int INF = 500001;
        int answer = 0;
        int[][] dist = new int[N + 1][N + 1];

        for (int[] d : dist)
            //fill은 배열의 모든값을 같은 값으로 초기화시켜줄 때 사용
            Arrays.fill(d, INF);

        for (int[] r : road) {
            if (dist[r[0]][r[1]] < r[2]) continue; // 이미 더 짧은 경로가 저장되어 있다면 패스
            dist[r[0]][r[1]] = r[2];
            dist[r[1]][r[0]] = r[2];
        }

        for (int i = 1; i <= N; i++) dist[i][i] = 0;

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            if (dist[1][i] <= K)
                answer++;
        }
        return answer;
    }
}