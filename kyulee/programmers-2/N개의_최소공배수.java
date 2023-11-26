public class N개의_최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int answer = arr[0];

            for (int num : arr) {
                answer = answer * num / gcd(answer, num);
            }
            return answer;
        }

        public int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }
}
