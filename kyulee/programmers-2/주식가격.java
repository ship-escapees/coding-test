

public class 주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    answer[i]++;
                    if (prices[i] > prices[j]) {
                        break;
                    }
                }
            }

            return answer;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] prices = {1, 2, 3, 2, 3};
            int[] result = solution.solution(prices);

            // 결과 출력
            for (int value : result) {
                System.out.print(value + " ");
            }
        }
    }
}
