class Solution {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    public int solution(int n, int[][] road, int k) {
        cnt = 0;
        arr = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = 500001;
            }
        }
        for (int i = 0; i < road.length; i++) {
            if(arr[road[i][0]][road[i][1]] > road[i][2]) {
                arr[road[i][0]][road[i][1]] = road[i][2];
                arr[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        dist = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            dist[i] = 500001;
        }
        visited = new boolean[n + 1];
        visited[1] = true;

        dijkstra(n, k);

        int answer = cnt;
        return answer;
    }
    static void dijkstra(int n, int k) {
        for (int i = 1; i < n; i++) {
            int min = 500001;
            int idx = 1;

            for (int j = 2; j <= n; j++) {
                if(!visited[j] && min > dist[j]) {
                    idx = j;
                    min = dist[j];
                }
            }

            visited[idx] = true;

            for (int j = 2; j <= n ; j++) {
                if(dist[j] > dist[idx] + arr[idx][j]) {
                    dist[j] = dist[idx] + arr[idx][j];
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            if(dist[i] <= k) {
                cnt++;
            }
        }
    }
}
