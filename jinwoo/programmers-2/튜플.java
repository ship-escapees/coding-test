import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        
        Arrays.sort(arr, (a, b) -> {return a.length() - b.length();});
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        int idx = 0;
        
        for(String str : arr) {
            for(String num : str.split(",")) {
                if(set.add(num.trim())) {
                    answer[idx++] = Integer.parseInt(num.trim());
                }
            }
        }
        
        return answer;
    }
}
