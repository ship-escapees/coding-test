import java.util.Arrays;

class Solution {
    public int[][] table;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        table = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                table[i][j] = num;
                num++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
    public int rotate(int[] t){
        int sX = t[0];
        int sY = t[1];
        int eX = t[2];
        int eY = t[3];

        int prev = table[sX][sY];
        int min = prev;
        for(int i = sY+1; i <= eY; i++){
            int temp = table[sX][i];
            table[sX][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = sX+1; i <= eX; i++){
            int temp = table[i][eY];
            table[i][eY] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = eY-1; i >= sY; i--){
            int temp = table[eX][i];
            table[eX][i] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }
        for(int i = eX-1; i >= sX; i--){
            int temp = table[i][sY];
            table[i][sY] = prev;
            min = Math.min(prev, min);
            prev = temp;
        }

        return min;
    }
}
