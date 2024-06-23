import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    public class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int n = discount.length;
            int totalDays = 0;

            Map<String, Integer> requiredProducts = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                requiredProducts.put(want[i], number[i]);
            }

            for (int i = 0; i <= n - 10; i++) {
                Map<String, Integer> currentWindow = new HashMap<>();

                for (int j = i; j < i + 10; j++) {
                    currentWindow.put(discount[j], currentWindow.getOrDefault(discount[j], 0) + 1);
                }


                boolean match = true;
                for (Map.Entry<String, Integer> entry : requiredProducts.entrySet()) {
                    if (currentWindow.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    totalDays++;
                }
            }

            return totalDays;
        }
    }
}
