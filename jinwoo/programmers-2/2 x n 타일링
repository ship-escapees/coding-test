class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] array = new int[n+1];
        array[1]=1;
        array[2]=2;
        for (int i = 3; i <= n; i++) {
            array[i]=(array[i-1]+array[i-2])%1000000007;
        }
        answer=array[n];
        return answer;
    }
}