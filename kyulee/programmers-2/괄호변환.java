import java.util.*;

class 괄호변환 {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int balancedIndex = findBalancedIndex(p);
        String u = p.substring(0, balancedIndex + 1);
        String v = p.substring(balancedIndex + 1);

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            String corrected = "(" + solution(v) + ")";
            String uTrimmed = u.substring(1, u.length() - 1);
            uTrimmed = reverseParentheses(uTrimmed);
            return corrected + uTrimmed;
        }
    }

    private int findBalancedIndex(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }
        return -1; // unreachable
    }

    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String reverseParentheses(String p) {
        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}