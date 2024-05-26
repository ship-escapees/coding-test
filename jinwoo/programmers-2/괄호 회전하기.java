import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        //s의 길이만큼 반복문을 돌면서 회전
        for (int i = 0; i < s.length(); i++) {
            //Stack을 생성하여 회전한 값들에 대해서 stack에 저장
            Stack<Character> sStack = new Stack<>();
            //Stack에 저장되는 처음 값이 ')', ']', '}' 의 경우 check 변수에 false저장
            Boolean check = true;
            for (int j = 0; j < s.length(); j++) {
                int index = j+i>=s.length() ? j+i-s.length() : j+i;
                if (sStack.size()==0 && ((s.charAt(index) == ')' || s.charAt(index) == '}' || s.charAt(index) == ']'))) {
                    check = false;
                    break;
                }
                //stack에 저장되어 있는 마지막 문자와 stack에 저장하려 하는 문자를 비교하여 서로 연관된 괄호라면 stack에서 지움
                if((sStack.size()>=1 && sStack.peek()=='(') && s.charAt(index)==')') {
                    sStack.pop();
                    continue;
                } else if ((sStack.size()>=1 && sStack.peek()=='[') && s.charAt(index)==']') {
                    sStack.pop();
                    continue;
                } else if ((sStack.size()>=1 && sStack.peek()=='{') && s.charAt(index)=='}') {
                    sStack.pop();
                    continue;
                }
                sStack.push(s.charAt(index));
            }

            //stack에 저장되어있는게 없고 check값이 true면 answer 변수에 ++
            if (sStack.size()==0 && check==true) answer++;
        }
        
        return answer;
    }
}