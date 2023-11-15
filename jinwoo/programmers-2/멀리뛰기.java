class Solution {
    public long solution(int n) {
        long answer = 0;
        //n의 범위대로 배열 생성
        int[] arr = new int[2000];
        //n=1일때와 n=2일때의 값을 미리 지정
        arr[0] = 1;
        arr[1] = 2;

        //점화식을 이용한 값 구하기
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        answer=arr[n-1];
        return answer;
    }
}