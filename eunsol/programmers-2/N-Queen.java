class Solution {

    static int[] arr;
    static int cnt;

    public int solution(int n) {
        int answer = 0;
        arr = new int[n];

        bt(n ,0);

        answer = cnt;
        return answer;
    }

    // BackTracking
    static void bt(int n, int row) {

        if(n == row) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if(possible(row)) {
                bt(n ,row + 1);
            }
        }
    }

    // 가로, 세로, 대각선 이동 가능한지
    static boolean possible(int row) {
        for (int i = 0; i < row; i++) {

            // 가로, 세로
            if(arr[i] == arr[row]) {
                return false;
            }

            // 대각선
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}