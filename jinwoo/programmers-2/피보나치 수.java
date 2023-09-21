class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fArray = new int[n+1];
        fArray[0] = 0;
        fArray[1] = 1;

        for (int i = 2; i < n+1; i++) {
            fArray[i] = (fArray[i-2] + fArray[i-1])%1234567;
        }
        answer = fArray[n];
        return answer;
    }
}