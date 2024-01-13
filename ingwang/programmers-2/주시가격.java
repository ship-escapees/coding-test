import java.util.*;

class Solution29 {
    public static int[] Solution29(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() &&prices[i]<prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
                stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1,2,3,4,5 };

        System.out.println(Solution29(a));
    }

}
