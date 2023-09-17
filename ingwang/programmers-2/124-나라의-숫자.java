class Solution1 {
   public static String solution1(int n) {

        String[] num = {"4", "1", "2"};
        String answer = "";
                
        for (int i = n; i >0; i/=3) {
            answer = num[ i % 3] + answer;
            if(i%3 == 0) {
                i -= 1;
            }
        }
            
         return answer;
  }

        
    public static void main(String[] args) {
        System.out.println(solution1(20));
    }
}   