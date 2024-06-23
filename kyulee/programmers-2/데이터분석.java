import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 데이터분석 {
    public class Solution {
        public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
            List<int[]> filteredData = new ArrayList<>();

            int extIndex = getIndex(ext);
            for (int[] entry : data) {
                if (entry[extIndex] < val_ext) {
                    filteredData.add(entry);
                }
            }

            int sortByIndex = getIndex(sort_by);
            filteredData.sort(Comparator.comparingInt(o -> o[sortByIndex]));

            return filteredData;
        }

        private int getIndex(String key) {
            switch (key) {
                case "code":
                    return 0;
                case "date":
                    return 1;
                case "maximum":
                    return 2;
                case "remain":
                    return 3;
                default:
                    throw new IllegalArgumentException("Invalid key: " + key);
            }
        }
    }
}
