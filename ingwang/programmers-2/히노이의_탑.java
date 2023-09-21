import java.util.ArrayList;

class Solution16 {
static ArrayList<int[]> seq;
    public static int[][] solution16(int n) {
        seq = new ArrayList<>();

        h(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for (int i = 0; i < seq.size(); i++) {
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    public static void h(int n, int a, int b, int v) {
        if(n == 1) {
            seq.add(new int[] {1,3});
            return;
        }else {
            h(n-1, a, v, b);
            seq.add(new int[] {a,b});
            h(n-1, v, b, a);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution16(5));
    }
}