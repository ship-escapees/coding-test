import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    public void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            list.add(new int[]{start, to});
            return;
        }

        hanoi(n - 1, start, to, mid);
        list.add(new int[]{start, to});
        hanoi(n - 1, mid, start, to);
    }
}
