class Solution {
    static int[] arr;
    static int answer;
    static int cnt;
    public int solution(int n) {
        cnt = n;
        arr = new int[cnt];

        bt(0);

        return answer;
    }
    static void bt(int row) {
        // 퀸이 n개이면
        if(cnt == row) {
            answer++;
            return;
        }
        for (int i = 0; i < cnt; i++) {
            arr[row] = i;
            if(check(row)) {
                bt(row + 1);
            }
        }
    }
    static boolean check(int row) {
        // 가로 세로 대각
        for (int i = 0; i < row; i++) {
            if(arr[i] == arr[row]) {
                return false;
            }
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
