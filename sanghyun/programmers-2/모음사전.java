class Solution {
    public int solution(String word) {
        int answer = word.length();
        String s = "AEIOU";
        int[] num = {781,156,31,6,1};
        for (int i = 0; i < word.length(); i++) {
            answer += num[i]*s.indexOf(word.charAt(i));
        }
        return answer;
    }
}
