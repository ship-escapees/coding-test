public class 피보나치-수 {
    public static int solution(int n) {
        return fibonacci(n);
    }

    private static int fibonacci(int n){
        int[] answer = new int[n+1];
        answer[1] = 1;

        for (int i = 2 ; i <= n; i++ ){
            answer[i] = (answer[i-2] + answer[i-1]) % 1234567;
        }

        return answer[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int answer = solution(n);
    }
}
