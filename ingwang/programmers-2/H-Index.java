import java.util.Arrays;

class Solution31 {
    public static int solution(int[] citations) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            cnt = citations.length -i;
            if (citations[i]>=cnt) {
                answer = cnt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = { 3, 0, 6, 1, 5 ,4};
        System.out.println(solution(a));
    }
}