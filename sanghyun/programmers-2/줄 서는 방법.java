import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        // 1부터 n까지의 숫자 리스트 생성
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 팩토리얼 계산을 위한 dp 배열 초기화
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        k--; // k를 0부터 시작하도록 조정

        for (int i = 0; i < n; i++) {
            int index = (int) (k / dp[n - 1 - i]); // 인덱스 계산
            answer[i] = list.remove(index);
            k %= dp[n - 1 - i];
        }

        return answer;
    }
}
