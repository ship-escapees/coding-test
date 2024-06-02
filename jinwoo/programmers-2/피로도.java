public class Solution {
    public int solution(int k, int[][] dungeons) {
        return exploreDungeons(k, dungeons, new boolean[dungeons.length], 0);
    }

    private int exploreDungeons(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                maxCount = Math.max(maxCount, exploreDungeons(fatigue - dungeons[i][1], dungeons, visited, count + 1));
                visited[i] = false;
            }
        }
        return maxCount;
    }

}
