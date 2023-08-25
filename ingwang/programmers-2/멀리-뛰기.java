class Solution9 {
   public static long solution9(int n) {
        long answer = 0;
        int x[] = new int[n+2];
        x[0]=0;
        x[1]=1;
        x[2]=2;
      
        for (int i = 3; i <= n; i++) {
            x[i] = (x[i-1] + x[i-2])%1234567;
        }
        answer = x[n];
        return answer;
    }
       
    public static void main(String[] args) {
        System.out.println(solution9(4));
    }
}   