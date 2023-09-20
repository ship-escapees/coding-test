class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean blank = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                blank = true;
                answer.append(Character.toUpperCase(c));
            } else if (blank) {
                answer.append(Character.toUpperCase(c));
                blank = false;
            } else {
                answer.append(Character.toLowerCase(c));
            }
        }

        return answer.toString();
    }
}
