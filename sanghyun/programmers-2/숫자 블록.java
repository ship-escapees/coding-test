import java.util.Arrays;

class Solution {

    public int[] solution(long begin, long end1) {
        // 범위가 어차피 int 범위 내에 있으므로 int 로 바꿔주고 계산 시작
        int start = (int) begin;
        int end = (int) end1;
        int[] answer = new int[(end - start) + 1];
        int idx = 0;

        // start end 범위 내에 answer 값을 채우는 for문
        for (int now = start; now < end + 1; now++) {
            // 소수일 경우 1
            int result = 1;
            // 2부터 Math.sqrt(now)까지 약수가 있는지 체크
            for (int i = 2; i <= Math.sqrt(now); i++) {
                // 약수일경우
                if (now % i == 0) {
                    // 최대 약수 받으려면, num / 1제외 최소 약수 = 최대 약수인데, 최대값이 천만이기 때문에
                    // 최대 약수가 천만을 넘지 않으면 최대약수를 넘김
                    if (now / i <= 10000000) {
                        result = now / i;
                        break;
                    } 
                        result = i;
                }
            }
            answer[idx++] = result;
        }
        if (start == 1) {
            answer[0] = 0;
        }
        return answer;
    }
}
