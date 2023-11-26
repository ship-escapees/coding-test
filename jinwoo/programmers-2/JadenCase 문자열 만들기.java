import java.util.*;
class Solution {
    public String solution(String s) {
        String answer="";
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(st.isEmpty() || st.peek().equals(" ")) {
                st.push(String.valueOf(s.charAt(i)).toUpperCase());
                answer+=st.peek();
            }
            else {
                st.push(String.valueOf(s.charAt(i)).toLowerCase());
                answer+=st.peek();
            }
        }
        return answer;
}
}