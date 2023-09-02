class Solution10 {
   public static int[] solution10(long begin, long end) {
        int[] answer = new int[(int) (end-begin)+1];
        int x=0;

        for (int i = (int) begin; i <= end; i++) {
            answer[x] = divisor(i);
            System.out.print(answer[x]);
            x+=1;
        }

        return answer;
  }

  public static int divisor (int x){
    if(x<=1){
        return 0;
    }
    for (int i = x/2; i >0; i--) {
        if(x%i==0){
            return i;
        }
    }
    return 0;
  }

        
    public static void main(String[] args) {
        System.out.println(solution10(1,10));
    }
}   