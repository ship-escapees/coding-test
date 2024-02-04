
class Solution17 {
    private static int[] q;
    private static int answer;

    public static int solution17(int n) {
        q = new int[n];

        bt(0, n);

        return answer;
    }

    private static void bt(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            q[depth] = i;
            if (valid(depth)) {
                bt(depth + 1, n);
            }
        }
    }

    private static boolean valid(int i) {
        for (int j = 0; j < i; j++) { 
            if (q[i] == q[j])
                return false;
            if (Math.abs(i - j) == Math.abs(q[i] - q[j]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution17(5));
    }
}