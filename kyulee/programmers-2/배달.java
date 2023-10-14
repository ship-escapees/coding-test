import java.util.*;

public class 배달 {
    public static int solution(int N, int[][] road, int K) {
        // 그래프를 나타내는 인접 리스트를 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int time = r[2];
            graph.get(from).add(new int[] { to, time });
            graph.get(to).add(new int[] { from, time });
        }

        // 다익스트라 알고리즘을 사용하여 1번 마을로부터의 최단 거리 계산
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        queue.offer(new int[] { 1, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentTown = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[currentTown]) {
                continue;
            }

            for (int[] next : graph.get(currentTown)) {
                int nextTown = next[0];
                int nextDistance = currentDistance + next[1];

                if (nextDistance < distance[nextTown]) {
                    distance[nextTown] = nextDistance;
                    queue.offer(new int[] { nextTown, nextDistance });
                }
            }
        }

        // 배달 가능한 마을의 개수를 계산
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,1}};
        int K = 3;

        int result = solution(N, road, K);
        System.out.println(result);
    }
}
