
public class 올바른 괄호 {

    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            while (s.contains("()")) {
                s = s.replace("()", "");
            }

            return s.isEmpty();
        }
    }

    public static void main(String[] args) {
        String test = "()()";
        boolean result = solution(test);
        System.out.println(result);

    }
}