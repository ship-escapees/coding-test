import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> cStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!cStack.isEmpty() && cStack.peek()==s.charAt(i)) {
                cStack.pop();
            } else cStack.push(s.charAt(i));
        }
        if(cStack.isEmpty()) {
            answer=1;
        } else answer=0;

        return answer;
    }
}