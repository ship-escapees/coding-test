
class Solution25 {
    public static int solution18(int n, int a, int b) {
        int answer = 0;
        while (true) {
            if (a%2==0){
                a= a/2;
            }else{
                a=a/2+1;
            }
            if(b%2==0){
                b=b/2;
            }else{
                b=b/2+1;
            }
            answer +=1;

            if(a==b){
                break;
            }            
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution18(8,4,7));
    }
}