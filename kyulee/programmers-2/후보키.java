import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int row = relation.length;
        int col = relation[0].length;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i < (1 << col); i++) {
            if (isMinimal(candidates, i)) {
                if (isUnique(relation, row, col, i)) {
                    candidates.add(i);
                }
            }
        }

        return candidates.size();
    }

    private boolean isMinimal(List<Integer> candidates, int key) {
        for (int candidate : candidates) {
            if ((candidate & key) == candidate) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(String[][] relation, int row, int col, int key) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if ((key & (1 << j)) > 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }
}