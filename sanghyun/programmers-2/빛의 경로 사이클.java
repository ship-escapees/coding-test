import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int row;
    int col;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    boolean[][][] isVisited;
    public int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<>();
        row = grid.length;
        col = grid[0].length();
        isVisited = new boolean[row][col][4];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    if(!isVisited[i][j][k]) {
                        list.add(move(grid, i, j, k));
                    }
                }
            }

        }
        return list.stream().sorted().mapToInt(i->i).toArray();
    }
    public int move(String[] grid, int i, int j, int k){
        int cnt = 0;

        while (!isVisited[i][j][k]){
            cnt++;
            isVisited[i][j][k] = true;
            if(grid[i].charAt(j) == 'L') k = (k+3) % 4;
            if(grid[i].charAt(j) == 'R') k = (k+1) % 4;
            i = (i+dx[k]+row) % row;
            j = (j+dy[k]+col) % col;
        }
        return cnt;
    }
}
