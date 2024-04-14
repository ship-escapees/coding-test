import java.util.*;

public class 메뉴리뉴얼 {
    class Solution {
        private Map<String, Integer> courseMap; // 각 코스요리 조합과 주문 횟수를 저장하는 맵

        // 각 주문에서 가능한 모든 코스요리 조합을 생성하는 함수
        private void generateCombinations(char[] order, int start, int count, StringBuilder sb) {
            if (count == 0) {
                String combination = sb.toString();
                courseMap.put(combination, courseMap.getOrDefault(combination, 0) + 1);
                return;
            }

            for (int i = start; i < order.length; i++) {
                sb.append(order[i]);
                generateCombinations(order, i + 1, count - 1, sb);
                sb.setLength(sb.length() - 1);
            }
        }

        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();

            for (int courseLength : course) {
                courseMap = new HashMap<>();

                for (String order : orders) {
                    char[] orderChars = order.toCharArray();
                    Arrays.sort(orderChars);
                    StringBuilder sb = new StringBuilder();
                    generateCombinations(orderChars, 0, courseLength, sb);
                }

                List<Map.Entry<String, Integer>> entries = new ArrayList<>(courseMap.entrySet());
                entries.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 주문 횟수로 내림차순 정렬

                if (!entries.isEmpty()) {
                    int maxCount = entries.get(0).getValue(); // 가장 많이 주문된 횟수

                    for (Map.Entry<String, Integer> entry : entries) {
                        if (entry.getValue() >= 2 && entry.getValue() == maxCount) {
                            answer.add(entry.getKey());
                        } else {
                            break; // 주문 횟수가 가장 많은 조합이 아니라면 종료
                        }
                    }
                }
            }

            Collections.sort(answer); // 사전 순으로 정렬
            return answer.toArray(new String[0]);
        }
    }
}
