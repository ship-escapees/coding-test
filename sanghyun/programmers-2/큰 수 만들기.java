import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            if (stack.isEmpty() || stack.peek() > num || k == 0) {
                stack.add(num);
            } else {
                while (stack.peek() < num){
                    stack.pop();
                    k--;
                    if(stack.isEmpty() || k == 0) break;
                }
                stack.add(num);
            }
        }
        for (int i = 0; i < stack.size() - k; i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}
