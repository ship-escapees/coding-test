import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int totalNodes;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 구성
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 모든 전선에 대해 시도
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 해당 전선을 끊는다고 가정
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n+1];
            totalNodes = 0;
            dfs(v1); // DFS로 송전탑 개수 탐색
            
            // 두 전력망의 차이 계산
            int diff = Math.abs(n - 2 * totalNodes);
            answer = Math.min(answer, diff);
            
            // 전선 복원
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    // DFS로 송전탑 개수를 탐색하는 함수
    public void dfs(int node) {
        visited[node] = true;
        totalNodes++;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
}