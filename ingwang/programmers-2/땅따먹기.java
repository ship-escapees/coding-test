class Solution8 {
    public static int solution8(int[][] land) {
            int answer = 0;
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));
        }
        answer = Math.max(Math.max(land[land.length-1][0],land[land.length-1][1]),Math.max(land[land.length-1][2],land[land.length-1][3]));
        return answer;
   }
      public static void main(String[] args) {
        int[][] arr = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
         System.out.println(solution8(arr));
     }
 }   
