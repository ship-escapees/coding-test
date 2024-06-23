import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filteredData = new ArrayList<>();

        // data 배열에서 ext 값이 val_ext보다 작은 데이터만 filteredData에 추가
        for (int[] row : data) {
            if (getValueByField(row, ext) < val_ext) {
                filteredData.add(row.clone());
            }
        }

        // sort_by에 해당하는 값을 기준으로 오름차순 정렬
        Collections.sort(filteredData, (o1, o2) -> {
            int value1 = getValueByField(o1, sort_by);
            int value2 = getValueByField(o2, sort_by);
            return Integer.compare(value1, value2);
        });

        // 정렬된 filteredData를 2차원 배열로 변환하여 반환
        int[][] result = new int[filteredData.size()][];
        for (int i = 0; i < filteredData.size(); i++) {
            result[i] = filteredData.get(i);
        }
        return result;
    }

    private int getValueByField(int[] row, String field) {
        switch (field) {
            case "code":
                return row[0];
            case "date":
                return row[1];
            case "maximum":
                return row[2];
            case "remain":
                return row[3];
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }
}
