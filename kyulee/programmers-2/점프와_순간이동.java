public class 점프와_순간이동 {
    public static int solution(int n) {
        int cnt = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }

            n--;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 5000;
        int result = solution(n);
        System.out.println(result);
    }
}
