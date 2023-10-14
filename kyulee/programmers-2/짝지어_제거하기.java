import java.util.LinkedList;

public class 짝지어_제거하기 {
    public static int solution(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "cdcd";
        int result = solution(s);
        System.out.println(result);
    }
}
