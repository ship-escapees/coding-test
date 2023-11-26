import java.util.ArrayList;

class Solution17 {
    public static int[][] solution17(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int j2 = 0; j2 < arr1[0].length; j2++) {
                    answer[i][j] +=arr1[i][j2] * arr2[j2][j];
                }
                
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {};
        int[][] b = {};
        System.out.println(solution17(a, b));
    }
}