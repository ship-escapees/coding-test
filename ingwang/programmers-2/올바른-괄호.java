class Solution6 {
   public static boolean solution6(String s) {
        boolean answer =true;
        int num[] = new int[s.length()];
        int result = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='('){
                num[i]=1;
            }else{
                num[i]=-1;
            }
            result += num[i];
            if (result<0){
                return false;
            }
        }
        if(result != 0){
            return false;
        }
        return answer;
  }

        
    public static void main(String[] args) {
        System.out.println(solution6("board"));
    }
}   