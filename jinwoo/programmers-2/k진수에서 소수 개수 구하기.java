import java.util.ArrayList;

public class Solution {
    public int solution(int n, int k) {
        // n을 k진수로 변환
        String kBase = Integer.toString(n, k);
        // 0을 기준으로 분할하여 소수 후보군 추출
        String[] candidates = kBase.split("0+");
        int count = 0;
        
        for (String candidate : candidates) {
            if (!candidate.isEmpty() && isPrime(Long.parseLong(candidate))) {
                count++;
            }
        }
        
        return count;
    }

    // 소수 판별 함수
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
