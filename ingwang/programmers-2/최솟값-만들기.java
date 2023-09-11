import java.util.Arrays;

class Solution14 {
    public static int solution14(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        if (A[A.length - 1] < B[B.length - 1]) {
            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - (i+1)];
            }
            return answer;

        }
        for (int i = 0; i < A.length; i++) {
            answer += B[i] * A[A.length - (i+1)];
        }
        return answer;

    }

    public static void main(String[] args) {
        int a[] = { 1, 4, 2 };
        int b[] = { 5, 4, 4 };
        System.out.println(solution14(a, b));
    }
}