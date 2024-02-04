
public class 조이스틱 {
    public static int solution(int n) {
        int answer = 0;  // 총 조작 횟수
        int move = name.length() - 1;  // 좌우 이동 횟수 초기값 설정

        // 상하 이동 횟수 계산
        for (int i = 0; i < name.length(); i++) {
            // 현재 문자에 대한 상하 이동 횟수 추가
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int index = i + 1;
            // 다음 A가 아닌 문자를 찾을 때까지 이동 횟수 계산
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            // 현재 위치에서의 좌우 이동 횟수 계산
            move = Math.min(move, i * 2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }

        // 최종 결과 반환
        return answer + move;
    }
}
