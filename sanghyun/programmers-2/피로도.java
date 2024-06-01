class Solution {
    boolean[] visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }
    public void dfs(int idx, int k, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(idx+1,k-dungeons[i][1],dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(idx, answer);
    }
}
