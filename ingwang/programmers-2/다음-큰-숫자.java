class Solution7 {
    public static int solution7(int n) {
        int answer = 0;
        int oneCount = count(n);
        while(true){
            n+=1;
            if(count(n)==oneCount){
                answer = n;
                break;
            }
        }
        return answer;
   }
   private static int count(int x){
    String num = Integer.toBinaryString(x);
    char []arr = num.toCharArray();
    int oneCount=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='1'){
                oneCount+=1;
            }
        }
    return oneCount;
   }
 
         
     public static void main(String[] args) {
         System.out.println(solution7(78));
     }
 }   
