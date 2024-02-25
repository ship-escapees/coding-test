class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder numbers = new StringBuilder();

        // 각 진법에 따른 숫자 저장
        for (int i = 0; i < t * m; i++) {
            numbers.append(Integer.toString(i, n).toUpperCase());
        }

        // 튜브가 말해야 하는 숫자 구하기
        for (int i = p - 1; i < t * m; i += m) {
            answer.append(numbers.charAt(i));
        }

        return answer.toString();
    }
}