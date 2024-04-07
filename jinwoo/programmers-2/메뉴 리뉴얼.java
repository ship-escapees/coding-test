import java.util.*;

class Solution {
    Map<String, Integer> map;
    int max = 0;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        for (int c : course) {
            map = new HashMap<>();
            max = 0;
            for (String order : orders) {
                findCombination("", 0, c, 0, order);
            }
            for (String key : map.keySet()) {
                if (map.get(key) == max && max > 1) {
                    answerList.add(key);
                }
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    private void findCombination(String comb, int start, int course, int length, String order) {
        if (length == course) {
            char[] arr = comb.toCharArray();
            Arrays.sort(arr);
            String sortedComb = new String(arr);
            map.put(sortedComb, map.getOrDefault(sortedComb, 0) + 1);
            max = Math.max(max, map.get(sortedComb));
            return;
        }
        for (int i = start; i < order.length(); i++) {
            findCombination(comb + order.charAt(i), i + 1, course, length + 1, order);
        }
    }
}