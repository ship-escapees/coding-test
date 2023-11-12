import java.util.ArrayList;

class Solution18 {
    public static String solution18(String s) {
        String answer = "";
        String[] a = s.split(" ");
        for (int i = 0; i < a.length; i++) {
            String b = a[i].toLowerCase();
            b = Character.toUpperCase(b.charAt(0)) + b.substring(1);
            answer += b;
            if (i < b.length() - 1) {
                answer += " ";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String a = "3asd qwe asd";
        System.out.println(solution18(a));
    }
}