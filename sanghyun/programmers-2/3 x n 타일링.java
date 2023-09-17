class Solution {
    final int MOD = 1000000007;

    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        long unique = 0;

        for (int i = 4; i <= n; i+=2) {
            unique += (2 * dp[i-4]) % MOD;
            dp[i] = (3 * dp[i-2] + unique) % MOD;
        }

        return (int)dp[n];
    }
}