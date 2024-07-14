import java.util.Stack;

public class 택배상자 {
    public class Solution {
        public int solution(int[] order) {
            Stack<Integer> subContainer = new Stack<>();
            int index = 0;

            for (int i = 1; i <= order.length; i++) {
                subContainer.push(i);

                while (!subContainer.isEmpty() && subContainer.peek() == order[index]) {
                    subContainer.pop();
                    index++;
                }
            }

            return index;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            // Test case 1
            int[] order1 = {4, 3, 1, 2, 5};
            System.out.println(sol.solution(order1)); // Expected output: 2

            // Test case 2
            int[] order2 = {5, 4, 3, 2, 1};
            System.out.println(sol.solution(order2)); // Expected output: 5
        }
    }

}
