import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        HashSet<String> wordSet = new HashSet<>();
        int order = 1;
        int person = 1;
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            person++;
            // 중복 단어가 나올 경우 중단
            if(wordSet.contains(words[i])){
                return answer = new int[]{person, order};
            }
            wordSet.add(words[i]);

            // 앞 단어의 마지막 알파벳과 일치하지 않으면 중단
            if((words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))){
                return answer = new int[]{person, order};
            }
            if(person == n){
                order++;
                person = 0;
            }
            if(i == words.length-1){
                return answer = new int[]{0,0};
            }
        }
        return answer;
    }
}
