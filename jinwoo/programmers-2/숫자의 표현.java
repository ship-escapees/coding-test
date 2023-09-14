class Solution {
    public int solution(int n) {
        int answer = 1;
        int tempNum;
        
         if (n == 1 || n == 2) {
            return answer;
        }

        for (int i = n/2+1; i > 0 ; i--) {
            tempNum=0;
            for (int j = 0; j < i; j++) {
                tempNum+=i-j;
                if (tempNum==n) answer++;
                if (tempNum > n) break;
            }
        }
        return answer;
    }
}