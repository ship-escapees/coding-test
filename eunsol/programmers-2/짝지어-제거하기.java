import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        String[] strArr = s.split("");

        for (String str : strArr) {
            if (!stack.empty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        return stack.empty() ? 1 : 0;
    }
}