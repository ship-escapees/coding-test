class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (true) {
            answer++;
            a = (a+1) / 2;
            b = (b+1) / 2;
            if (a == 1 && b == 1 || a == b){
                return answer;
            }
        }
    }
}
