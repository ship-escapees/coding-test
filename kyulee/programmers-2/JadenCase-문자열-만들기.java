
/*
1. s를 CharArray로 만들어서 반복
2. 공백이 나오면 prefix 값을 0으로 초기화 -> 공백이 나왔으니 0으로 초기화하고, 0일 경우에만 대문자로 바꾸도록 수정
3. 스트링 빌더에 넣어놨다가 스트링으로 변경
 */

public class JadenCase-문자열-만들기 {
    public static String solution(String s) {
        StringBuilder builder = new StringBuilder();
        int prefix = 0;

        for (char c : s.toCharArray()) {
            if (c == 32) {
                prefix = 0;
            } else {
                c = prefix == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c);
                prefix++;
            }
            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String n = "3people unFollowed     me";
        String answer = solution(n);
    }
}
