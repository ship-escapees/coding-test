import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public class Solution {
        public String[] solution(String[] players, String[] callings) {
            // 선수들의 순서를 저장하는 맵과 이름에 대한 현재 위치를 저장하는 맵을 준비합니다.
            Map<String, Integer> nameToPosition = new HashMap<>();
            for (int i = 0; i < players.length; i++) {
                nameToPosition.put(players[i], i);
            }

            // 해설진이 부른 이름에 대해 순서를 바꿉니다.
            for (String called : callings) {
                int currentPosition = nameToPosition.get(called);
                if (currentPosition > 0) {
                    // 현재 선수와 앞선 선수의 위치를 바꿉니다.
                    String previousPlayer = players[currentPosition - 1];

                    // 선수들의 순서를 교체합니다.
                    players[currentPosition - 1] = called;
                    players[currentPosition] = previousPlayer;

                    // 맵에서 위치 정보를 업데이트합니다.
                    nameToPosition.put(called, currentPosition - 1);
                    nameToPosition.put(previousPlayer, currentPosition);
                }
            }

            return players;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            // Test case 1
            String[] players1 = {"mumu", "soe", "poe", "kai", "mine"};
            String[] callings1 = {"kai", "kai", "mine", "mine"};
            String[] result1 = sol.solution(players1, callings1);
            for (String player : result1) {
                System.out.print(player + " ");
            }
            // Expected output: mumu kai mine soe poe
        }
    }

}
