public class Solution {
    public int solution(String s) {
        int minLen = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = "";
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                String next = "";

                if (j + i > s.length()) {
                    next = s.substring(j);
                } else {
                    next = s.substring(j, j + i);
                }

                if (prev.equals(next)) {
                    count++;
                } else {
                    compressed += (count > 1) ? count + prev : prev;
                    prev = next;
                    count = 1;
                }
            }

            compressed += (count > 1) ? count + prev : prev;
            minLen = Math.min(minLen, compressed.length());
        }

        return minLen;
    }
    
}