import java.util.*;

public class 전력망을둘로나누기 {
    public class Solution {
        public int solution(int n, int[][] wires) {
            int minDifference = n;

            // 그래프를 인접 리스트로 표현
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] wire : wires) {
                graph[wire[0]].add(wire[1]);
                graph[wire[1]].add(wire[0]);
            }

            // 각 간선을 제거하면서 두 서브 트리의 크기를 계산
            for (int[] wire : wires) {
                int node1 = wire[0];
                int node2 = wire[1];

                // 간선 제거
                graph[node1].remove(Integer.valueOf(node2));
                graph[node2].remove(Integer.valueOf(node1));

                // BFS 또는 DFS를 사용하여 두 서브 트리의 크기를 계산
                int size1 = bfs(graph, node1, n);
                int size2 = bfs(graph, node2, n);

                // 크기 차이의 절대값을 계산하여 최소값을 갱신
                int difference = Math.abs(size1 - size2);
                minDifference = Math.min(minDifference, difference);

                // 간선 복구
                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            return minDifference;
        }

        private int bfs(List<Integer>[] graph, int start, int n) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited[start] = true;
            int count = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                count++;
                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            return count;
        }
    }
}
