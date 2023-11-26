import java.util.*;

class Solution24 {
    public static int[] solution24(int n, String[] words) {
        int[] answer = new int[2];
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (strings.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else {
                answer[0] = 0;
                answer[1] = 0;
            }
            strings.add(words[i]);
            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;

            } else {
                answer[0] = 0;
                answer[1] = 0;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a = { "a", "b" };
        System.out.println(solution24(1, a));
    }
}
