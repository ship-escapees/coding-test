import java.util.Arrays;

class Solution {
    int x;
    int y;
    int[] mx = {1,0,-1,0};
    int[] my = {0,-1,0,1};
    boolean[][] visited;
    int answer;
    public int solution(int[][] maps) {
        answer = 0;
        x = 0;
        y = 0;
        visited = new boolean[maps.length][maps.length];
        move(x,y,maps,0);
        if(maps[maps.length-1][maps.length-1] == 1) return -1;
        return maps[maps.length-1][maps.length-1];
    }
    public void move(int x, int y, int[][] maps,int num) {

        if(x < 0 || y < 0 || x > maps.length-1 || y > maps.length-1) return;
        if(maps[x][y] == 0 || visited[x][y]) return;

        if(visited[x][y]) {
            maps[x][y] = Math.min(maps[x][y],num+1);
        }else {
            maps[x][y] = num + 1;
        }
        for (int i = 0; i < 4; i++) {
            visited[x][y] = true;
            move(x + mx[i], y + my[i], maps, maps[x][y]);
            visited[x][y] = false;
        }

    }
}