import java.util.*;

class Solution {
    private List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i][0] = moves.get(i)[0];
            answer[i][1] = moves.get(i)[1];
        }
        return answer;
    }

    private void hanoi(int n, int start, int end, int temp) {
        if (n == 1) {
            moves.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, temp, end);

        moves.add(new int[]{start,end});

        hanoi(n - 1,temp,end,start);
    }
}