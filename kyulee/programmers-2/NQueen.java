import java.util.ArrayList;
import java.util.List;

public class NQueen {
    class Solution {
        public int solution(int n) {
            return dfs(n, new ArrayList<>());
        }

        private boolean check(List<Integer> ls, int newCol) {
            for (int i = 0; i < ls.size(); i++) {
                int existingCol = ls.get(i);
                // 같은 열에 퀸을 둔 적이 있거나, 대각 위치에 둔 적이 있다면, false를 반환
                if (newCol == existingCol || ls.size() - i == Math.abs(existingCol - newCol)) {
                    return false;
                }
            }
            return true;
        }

        private int dfs(int n, List<Integer> ls) {
            // 끝 행까지 도달! 1을 반환
            if (ls.size() == n) {
                return 1;
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (check(ls, i)) {
                    ls.add(i);
                    cnt += dfs(n, ls);
                    ls.remove(ls.size() - 1);
                }
            }
            // 탐색 결과를 반환
            return cnt;
        }
    }
}
