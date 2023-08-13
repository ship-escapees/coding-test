class Solution5 {
   public static int solution5(int [][]board) {
        int answer = 0;
        int min =0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
            //    if (board[i][j]==0){
            //         continue;
            //    }
                min = Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i][j-1]);
               if(min !=0){
                   board[i][j]=min+1;
                   if(answer<board[i][j]){
                        answer = board[i][j];
                   }
               }
            }
            
        }

        return answer*answer;

  }

        
    public static void main(String[] args) {
        int [][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution5(board));
    }
}   