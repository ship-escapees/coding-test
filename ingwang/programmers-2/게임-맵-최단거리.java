import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

   public static int solution2(int[][] maps) {

        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0}); // 시작점
        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] m = q.poll();
            int x = m[0];
            int y = m[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <0 || nx > maps.length -1 || ny <0 || ny > maps[0].length-1){
                    continue;
                }

                if (visited[nx][ny]==0 && maps[nx][ny]==1){
                    visited[nx][ny] = visited[x][y]+1;
                    q.add(new int[]{nx,ny});
                }

            }
        }

        answer = visited[maps.length-1][maps[0].length-1];

        if(answer==0){
            answer = -1;
        }

        return answer;

  }

        
    public static void main(String[] args) {
        int [][] x = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}; 
        System.out.println(solution2(x));
    }
}   