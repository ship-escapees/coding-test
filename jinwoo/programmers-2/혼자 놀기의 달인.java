import java.util.*;

public class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n + 1]; // 방문 여부 체크 배열
        List<Integer> groupSizes = new ArrayList<>(); // 그룹 크기 리스트

        // 모든 상자에 대해 그룹을 찾기
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int groupSize = 0;
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current - 1];
                    groupSize++;
                }
                groupSizes.add(groupSize);
            }
        }
        
        // 그룹 크기를 내림차순으로 정렬
        Collections.sort(groupSizes, Collections.reverseOrder());

        // 가장 큰 두 그룹 크기를 곱하여 점수 계산
        if (groupSizes.size() < 2) {
            return 0; // 그룹이 하나만 있거나 그룹이 아예 없는 경우 점수는 0
        } else {
            return groupSizes.get(0) * groupSizes.get(1);
        }
    }

}
