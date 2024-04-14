import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0,1);
            s = s.substring(1, s.length());
            s += str;
            if(check(s)){
                answer++;
            }
        }
        return answer;
    }
    
    private boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.add(c);
            }else{
                if (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if(c == ')' && pop =='(')continue;
                    if(c == '}' && pop =='{')continue;
                    if(c == ']' && pop =='[')continue;
                    return false;
                }
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
