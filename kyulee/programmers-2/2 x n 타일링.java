
// 가로 길이가 2이고 세로의 길이가 1인 직사각형 모양 타일로 이 직사각형 타일을 이용하여 세로의 길이가 3이고 가로의 길이가 n인 바닥을 가득 채우려면 몇개의 경우의 수가 있는지 찾기
// n = 1 일때 1, n = 2 일때 2, n = 3 일때 3, n = 4 일때 5
// 피보나치 수열 이용

public class 2xn타일링 {
    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;                          // 가로 길이가 1일때의 경우의 수
        dp[2] = 2;                          // 가로 길이가 2일때의 경우의 수

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = solution(4);
        System.out.println(result);
    }
}
