import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int place = 0; place < places.length; place++) {
            int cheak = 1; 
            String[] list = places[place];

            firstLoop:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    char c = places[place][i].charAt(j);
                    if (c == 'P') {
                        if (!bfs(i,j,list)) { 
                            cheak = 0; 
                            break firstLoop; 
                        }
                    }
                }
            }
            answer[place] = cheak; 
        }
        return answer;
    }

    public boolean bfs(int currentX, int currnetY,String[] list) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{currentX,currnetY});

        while (!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = now[0] + x[i];
                int nowY = now[1] + y[i];

                if(nowX < 0 || nowY < 0 || nowX >= 5 || nowY >= 5 || (nowX == currentX && nowY == currnetY)) continue;

                int distance = Math.abs(nowX - currentX) + Math.abs(nowY - currnetY);

                if(distance <= 2 && list[nowX].charAt(nowY) == 'P') return false;
                else if(list[nowX].charAt(nowY) == 'O' && distance< 2) q.add(new int[] {nowX,nowY});
            }
        }
        return true;
    }
}
