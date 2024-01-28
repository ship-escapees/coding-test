class Solution {
  public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length - 1; // 초기 최소 이동 횟수는 커서를 끝까지 오른쪽으로 이동하는 경우로 설정

        for (int i = 0; i < length; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 알파벳 조작 횟수 계산

            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') { // 연속된 A의 개수를 구함
                next++;
            }

            int move = i + length - next + Math.min(i, length - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
    }
}