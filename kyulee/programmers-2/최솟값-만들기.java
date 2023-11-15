
public class 최솟값-만들기 {
    /*
     이전에 파이썬으로 풀었던 풀이
     def solution(A,B):
        answer = 0

        A.sort()
        B.sort(reverse=True)

        for i in range(len(A)):
            answer += A[i] * B[i]

        return answer
     */

    public static int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0 ; i < A.length; i++){
            answer += A[i] * B[A.length - 1 - i];
        }
        return answer;
    }
}