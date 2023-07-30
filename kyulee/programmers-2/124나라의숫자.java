
// n을 3으로 나눴을 때 몫이 0이면 -1, 나머지가 1이상 있으면 그대로 사용
// n을 3으로 나눴을 때 나머지가 1로 떨어지면 1, 2로 떨어지면 2, 0으로 떨어지면 4

public class 124_나라의_숫자 {

    public static String solution(int n) {
        if (n == 0) {
            return "";
        }

        int remainder = n % 3;
        int quotient = n / 3;

        if (remainder == 0) {
            quotient--;
        }

        return solution(quotient) + convertor(remainder);
    }

    public static String convertor(int num) {
        if (num == 0) {
            return "4";
        } else if (num == 1) {
            return "1";
        } else {
            return "2";
        }
    }

    public static void main(String[] args) {
        int n = 9;
        String answer = solution(n);
        System.out.println(answer);
    }
}