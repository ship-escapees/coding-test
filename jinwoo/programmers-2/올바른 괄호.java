import java.util.*;
class Solution {
	public boolean solution(String s) {
		boolean answer=false;
        //주어진 문자열에서 첫번째 문자가 닫는 괄호일 경우 false 리턴
		if(s.charAt(0)==')') return answer;
		
		Stack<Character> st = new Stack<>();
		for(int i=0; i<s.length(); i++) {
            //문자열에서 여는 괄호인 경우 스택에 추가
			if(s.charAt(i)=='(') st.add(s.charAt(i));
            //스택이 비어있지 않고(==스택에 여는괄호가 있고) 문자열에 닫는 괄호가 올 경우 가장 마지막에 추가한 여는 괄호 스택에서 삭제
			else if(!st.isEmpty() && s.charAt(i)==')') st.pop(); 
            //올바르지 않은 케이스의 경우 false 값 리턴
			else return answer;
		}
		if(st.isEmpty()) answer=true;
		return answer;
	}
}