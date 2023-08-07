package org.example;

// 점화식을 이용

public class 3xn타일링 {
    public static long solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;                   // 가로 길이가 1일 때의 경우의 수는 1
        dp[2] = 3;                   // 가로 길이가 2일 때의 경우의 수는 3

        for (int i = 3; i <= n; i++) {                                          // 점화식을 이용하여 현재 가로 길이 i에서의 경우의 수를 구함.
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long test = solution(4);
        System.out.println(test);
    }
}
