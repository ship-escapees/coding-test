public class 양궁대회 {
    class Solution {
        private int maxDiff = Integer.MIN_VALUE;
        private int[] bestStrategy = new int[11];

        public int[] solution(int n, int[] info) {
            int[] ryan = new int[11];
            dfs(info, ryan, n, 0);
            if (maxDiff <= 0) {
                return new int[]{-1};
            }
            return bestStrategy;
        }

        private void dfs(int[] info, int[] ryan, int arrowsLeft, int index) {
            if (index == 11) {
                if (arrowsLeft > 0) {
                    ryan[10] += arrowsLeft;  // 남은 화살은 0점에 모두 사용
                }
                int scoreDiff = calculateScoreDifference(info, ryan);
                if (scoreDiff > maxDiff || (scoreDiff == maxDiff && isBetterStrategy(ryan))) {
                    maxDiff = scoreDiff;
                    bestStrategy = ryan.clone();
                }
                if (arrowsLeft > 0) {
                    ryan[10] -= arrowsLeft;  // 0점에 쏜 화살을 원래대로 되돌림
                }
                return;
            }

            if (arrowsLeft > info[index]) {
                ryan[index] = info[index] + 1;  // 이 점수에서 이길 수 있는 최소 화살 사용
                dfs(info, ryan, arrowsLeft - ryan[index], index + 1);
                ryan[index] = 0;  // 상태 되돌리기
            }

            dfs(info, ryan, arrowsLeft, index + 1);
        }

        private int calculateScoreDifference(int[] info, int[] ryan) {
            int ryanScore = 0;
            int appeachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && ryan[i] == 0) continue;
                if (info[i] >= ryan[i]) {
                    appeachScore += 10 - i;
                } else {
                    ryanScore += 10 - i;
                }
            }
            return ryanScore - appeachScore;
        }

        private boolean isBetterStrategy(int[] ryan) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] != bestStrategy[i]) {
                    return ryan[i] > bestStrategy[i];
                }
            }
            return false;
        }
    }
}
