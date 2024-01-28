class Solution33 {
    public static  int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 3; i <= (brown+yellow); i++) {
            int y=i;
            int x = (brown+yellow)/y;

            if(x<3){
                continue;
            }
            if (x>=y){
                if((x-2)*(y-2)==yellow){
                    answer[0] = x;
                    answer[1]= y;
                    break;
                }
            }
        }


         return answer;
   }
 
         
     public static void main(String[] args) {
         System.out.println(solution(4,5));
     }
 }   