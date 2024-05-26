import java.util.*;

public class Solution {
    public static List<Integer> solution(int n, long left, long right) {
        List<Integer> result = new ArrayList<>();
        
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            result.add(Math.max(row, col) + 1);
        }
        
        return result;
    }

}
