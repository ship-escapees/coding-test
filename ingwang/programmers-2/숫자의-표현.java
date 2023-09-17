class Solution11 {
    public static int solution11(int n) {
        int answer = 1;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = i;
            for (int j = i + 1; j <= n; j++) {
                num += j;
                if (num >= n) {
                    if (num == n) {
                        answer += 1;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution11(15));
    }
}