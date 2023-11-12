import java.util.Stack;

class Solution19 {
    public static int solution19(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        int answer = 0;
        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution19("baabaa"));
    }
}
