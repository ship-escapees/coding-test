
public class 숫자의 표현 {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;

            while (true) {
                sum += num;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                } else {
                    num++;
                }
            }
        }

        return answer;
    }
}