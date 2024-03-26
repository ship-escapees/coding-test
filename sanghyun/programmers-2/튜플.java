import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] list = s.split("}");
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i].substring(2);
        }
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        for (String value : list) {
            String[] str = value.split(",");
            for (String item : str) {
                int num = Integer.parseInt(item);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        return answer;
    }
}
