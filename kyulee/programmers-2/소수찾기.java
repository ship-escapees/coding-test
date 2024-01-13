
public class 소수찾기 {
    static boolean[] visited;
    static HashSet<Integer> set;

    public static int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, "", i);
        }

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    static void permutation(String numbers, String current, int length) {
        if (current.length() == length) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, current + numbers.charAt(i), length);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
