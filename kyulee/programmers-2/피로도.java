public class 피로도 {
    class Solution {
        private int maxDungeons = 0;

        public int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            exploreDungeons(k, dungeons, visited, 0);
            return maxDungeons;
        }

        private void exploreDungeons(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
            // 모든 가능한 던전 탐험 순서를 시도하면서 최대 던전 수를 업데이트
            maxDungeons = Math.max(maxDungeons, count);

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                    // 현재 던전을 탐험
                    visited[i] = true;
                    exploreDungeons(currentFatigue - dungeons[i][1], dungeons, visited, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
