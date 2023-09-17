class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];

        for (int i = (int)begin,idx = 0; i <= end; i++) {
            answer[idx++] = (int) getMaxDivisor(i);
        }
        return answer;
    }

    private static long getMaxDivisor(long x) {
        if (x == 1) {
            return 0;
        }

        for (long i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return Math.max(i, x / i <= 10000000 ? x / i : 0);
            }
        }

        return 1;
    }
}