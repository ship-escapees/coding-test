class Solution {
    public int solution(int n) {
        int answer = 1;
        if(n == 1){
            return answer;
        }
        while (true){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                answer++;
            }
            if(n == 1){
                return answer;
            }
        }
    }
}
