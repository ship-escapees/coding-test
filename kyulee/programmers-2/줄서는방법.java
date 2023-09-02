
public class 즐서는 방법 {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nList = new ArrayList<>();
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            nList.add(i);
            factorial *= i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int idx = (int) (k / factorial);
            k %= factorial;

            answer[i] = nList.get(idx);
            nList.remove(idx);
        }

        return answer;
    }
}