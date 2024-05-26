public class 모음사전 {
    class Solution {
        public int solution(String word) {
            int answer = 0;
            int[] weights = {781, 156, 31, 6, 1}; // 각 자리수의 가중치

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = "AEIOU".indexOf(c); // 각 자리의 알파벳이 몇 번째 알파벳인지

                answer += weights[i] * index + 1; // 해당 자리수의 가중치와 알파벳의 순서를 곱하여 더함
            }

            return answer;
        }
    }
}
