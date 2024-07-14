import java.util.*;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수들의 현재 등수를 저장할 맵
        Map<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        // 호출된 선수들을 처리
        for (String calling : callings) {
            int currentRank = rankMap.get(calling);
            if (currentRank > 0) {
                // 앞의 선수와 자리 교환
                String previousPlayer = players[currentRank - 1];
                players[currentRank - 1] = calling;
                players[currentRank] = previousPlayer;

                // 등수 업데이트
                rankMap.put(calling, currentRank - 1);
                rankMap.put(previousPlayer, currentRank);
            }
        }

        return players;
    }

}
