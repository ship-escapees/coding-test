

// 내 위치부터, 상대편 위치까지의 최소 거리를 구하는 프로그램
// 동서남북으로만 이동 가능하며, 0은 막혀있는 블록으로 이동할 수 없고 1인곳만 이동할 수 있음

public class 게임-맵-최단거리 {

    static int[]dx={-1,1,0,0};
    static int[]dy={0,0,-1,1};
    static boolean[][]visited;

    public static int solution(int[][]maps){
        int n=maps.length;
        int m=maps[0].length;
        visited=new boolean[n][m];

        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0]=true;

        while(!queue.isEmpty()){
            int[]pos=queue.poll();
            int x=pos[0];
            int y=pos[1];
            int count=pos[2];

            if(x==m-1&&y==n-1){
            return count;
            }

            for(int i=0;i< 4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

                if(nx>=0&&nx<m &&ny>=0&&ny<n &&maps[ny][nx]==1&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    queue.add(new int[]{nx,ny,count+1});
                }
            }
        }

        return-1;
    }

    public static void main(String[]args){
            int[][]maps1={
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
            };
            int answer1=solution(maps1);
            System.out.println(answer1);

            int[][]maps2={
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,0},
            {0,0,0,0,1}
            };
            int answer2=solution(maps2);
            System.out.println(answer2);
    }
}