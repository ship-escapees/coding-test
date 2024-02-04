class Solution23 {
    public static int solution23(int n) {
        int answer = 0;
        while(n!=0){
            if(n%2 ==0){
                n/=2;
            }else{
                n -= 1;
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution23(5));
    }
}
