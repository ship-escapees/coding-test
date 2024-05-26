
import java.util.*; 

public class n2배열자르기 {
    public class Solution {
        public int[] solution(int n, long left, long right) {
            int len = (int)(right - left + 1);
            int[] result = new int[len];

            for (long idx = left; idx <= right; idx++) {
                int row = (int)(idx / n);
                int col = (int)(idx % n);
                result[(int)(idx - left)] = Math.max(row, col) + 1;
            }

            return result;
        }
    }
}
