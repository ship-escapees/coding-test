
public class 큰수만들기 {
class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        int remain = len - k; // 남은 숫자의 개수
        int start = 0; // 검사할 시작 위치

        StringBuilder answer = new StringBuilder();

        // 남은 숫자의 개수만큼 반복
        while (remain > 0) {
            int maxIdx = start; // 현재 범위에서 가장 큰 숫자의 인덱스
            char maxChar = number.charAt(start); // 현재 범위에서 가장 큰 숫자

            // 현재 범위 내에서 가장 큰 숫자 찾기
            for (int i = start + 1; i <= len - remain; i++) {
                char currentChar = number.charAt(i);
                if (currentChar > maxChar) {
                    maxChar = currentChar;
                    maxIdx = i;
                }
            }

            answer.append(maxChar); // 가장 큰 숫자 추가
            start = maxIdx + 1; // 다음 범위의 시작 위치 설정
            remain--; // 한 숫자를 추가했으므로 남은 숫자의 개수 감소
        }

        return answer.toString();
        }
    }
}
