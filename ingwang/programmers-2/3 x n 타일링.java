class Solution4 {
   public static int solution4(int n) {
        // int answer = 0;

        // int[] num = new int[n+1];
        // int mod = 1000000007;
        // num[0]=1;
        // num[2]=3;

        // for (int i = 4; i <= n ; i+=2) {
        //     num[i]= (num[i-2]*4%mod -num[i-4]%mod +mod)%mod;            
        // }
        // answer = num[n];
        // return answer;


        int answer = 0;

        int[] num = new int[n+1];
        int sum = 0;
        num[0]=1;
        num[2]=3;

        for (int i = 4; i <= n ; i+=2) {
            num[i] = (num[i-2]*3 + num[i-4]*2)%1000000007;
            answer = answer+(num[i-2]);
            
        }
        answer = num[n];
        return answer;

  }

        
    public static void main(String[] args) {
        System.out.println(solution4(4));
    }
}   