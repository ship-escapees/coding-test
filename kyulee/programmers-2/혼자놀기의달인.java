import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 혼자놀기의달인 {
    public class Solution {
        public int solution(int[] cards) {
            int n = cards.length;
            boolean[] visited = new boolean[n];
            List<Integer> groupSizes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int currentIndex = i;
                    int groupSize = 0;

                    while (!visited[currentIndex]) {
                        visited[currentIndex] = true;
                        currentIndex = cards[currentIndex] - 1;
                        groupSize++;
                    }

                    groupSizes.add(groupSize);
                }
            }

            Collections.sort(groupSizes, Collections.reverseOrder());

            if (groupSizes.size() < 2) {
                return 0;
            }

            return groupSizes.get(0) * groupSizes.get(1);
        }
    }
}
