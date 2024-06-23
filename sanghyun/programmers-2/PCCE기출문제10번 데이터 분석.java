import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

class Solution {
        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            Map<String, Integer> map = new HashMap<>();
            map.put("code", 0);
            map.put("date", 1);
            map.put("maximum", 2);
            map.put("remain", 3);

            int extIndex = map.get(ext);
            int sortIndex = map.get(sort_by);

            ArrayList<int[]> answerList = new ArrayList<>();
            for (int[] item : data) {
                if (item[extIndex] < val_ext) {
                    answerList.add(item);
                }
            }
            answerList.sort(Comparator.comparingInt(arr -> arr[sortIndex]));

            int[][] answer = new int[answerList.size()][data[0].length];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
            return answer;
        }
}
