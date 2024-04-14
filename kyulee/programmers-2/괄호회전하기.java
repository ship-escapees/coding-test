import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                Deque<Character> deque = new ArrayDeque<>();
                for (char c : s.toCharArray()) {
                    deque.add(c);
                }
                // rotate를 구현하기 위해 deque의 첫 번째 요소를 뒤로 보냄
                for (int j = 0; j < i; j++) {
                    char first = deque.pollFirst();
                    deque.addLast(first);
                }

                StringBuilder sb = new StringBuilder();
                for (char c : deque) {
                    sb.append(c);
                }
                String rotated = sb.toString();

                // 문자열에서 [], {}, ()를 제거
                while (rotated.contains("[]") || rotated.contains("{}") || rotated.contains("()")) {
                    rotated = rotated.replace("[]", "").replace("{}", "").replace("()", "");

                    if (rotated.isEmpty()) { // 문자열이 비어있으면
                        answer++; // answer 증가
                    }
                }
            }

            return answer;
        }
    }
}
