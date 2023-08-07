class Solution3 {
   public static int solution3(int n) {
        int answer = 0;

        int[] num = new int[n];
        int sum = 0;
        num[0]=1;
        num[1]=2;

        for (int i = 2; i < n ; i++) {
            sum = num[i-2] + num[i-1];
            num[i] = sum % 1000000007;
        }
        answer = num[n-1];
        return answer;
  }

        
    public static void main(String[] args) {
        System.out.println(solution3(4));
    }
}   