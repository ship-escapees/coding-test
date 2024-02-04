import java.util.ArrayList;

class Solution {
static ArrayList<Integer> list = new ArrayList<>();

    public static int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                answer++;
            }
        }
        return answer;
    }

    //소수찾기 알고리즘
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str) {
        int n = str.length();
        if (!prefix.equals("")) {
            int num = Integer.valueOf(prefix);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
    }
}