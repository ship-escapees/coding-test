import java.util.stream.Collectors;
public class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }
        
        if (isCorrect(p)) {
            return p;
        }
        
        return convertToCorrect(p);
    }
    
    // 올바른 괄호 문자열인지 확인하는 메소드
    private boolean isCorrect(String str) {
        int balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') balance++;
            else if (ch == ')') balance--;
            
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
    
    // 균형잡힌 괄호 문자열을 올바른 괄호 문자열로 변환하는 메소드
    private String convertToCorrect(String w) {
        if (w.isEmpty()) {
            return "";
        }
        
        String u = "";
        String v = "";
        int balance = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') balance++;
            else if (w.charAt(i) == ')') balance--;
            
            if (balance == 0) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }
        
        if (isCorrect(u)) {
            return u + convertToCorrect(v);
        } else {
            String temp = "(" + convertToCorrect(v) + ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            u = u.chars()
                 .mapToObj(c -> (char) c == '(' ? ")" : "(") // 괄호 방향을 뒤집음
                 .collect(Collectors.joining());
            return temp + u;
        }
    }
}