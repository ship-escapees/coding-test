import java.util.*;

class Solution32 {
    static boolean[] visited;
    static Set<Integer> map = new HashSet<>();

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        backTracking(0, numbers, "");
        return map.size();
    }

    public static void backTracking(int depth, String numbers, String current) {
        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String number = current + numbers.charAt(i);

                if (isPrime(Integer.parseInt(number))) {
                    map.add(Integer.parseInt(number));
                }

                backTracking(depth + 1, numbers, number);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "17";
        System.out.println(solution(a));
    }
}