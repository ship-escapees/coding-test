
public class 행렬의-곱셈  {
    public static int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++){        // 0~3
            for (int j = 0 ; j < answer[i].length; j++){   // 0 ~ 2
                answer[i][j] = 0;

                for (int k = 0 ; k < arr1[i].length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = {{3,3}, {3,3}};
        int[][] answer = solution(arr1, arr2);
    }
}
