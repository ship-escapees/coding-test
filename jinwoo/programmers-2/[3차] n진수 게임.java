public class Solution {
  
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder gameNumbers = new StringBuilder("0"); // 게임에서 말해야하는 숫자를 저장할 StringBuilder
        int count = 0;

        // 필요한 숫자의 개수가 될 때까지 게임 숫자를 생성
        while (gameNumbers.length() < m * t) {
            gameNumbers.append(convertToNBase(++count, n));
        }

        for (int i = 0; i < t; i++) {
            int charIndex = m * i + p - 1;
            answer.append(gameNumbers.charAt(charIndex));
        }

        return answer.toString();
    }

    // 주어진 숫자를 n진법으로 변환하는 메서드
    private String convertToNBase(int num, int n) {
        StringBuilder nBase = new StringBuilder();
        char[] baseChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (num > 0) {
            nBase.insert(0, baseChar[num % n]);
            num /= n;
        }
        return nBase.toString().isEmpty() ? "0" : nBase.toString();
    }

}