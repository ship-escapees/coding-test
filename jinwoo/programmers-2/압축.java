import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int dictionaryIdx = 27;

        for(int i = 0; i < 26; i++) {
            char c = (char) (65 + i);
            dictionary.put(String.valueOf(c), i+1);
        }

        while(!msg.isEmpty()) {
            String w = "";
            for(int i = 1; i <= msg.length(); i++) {
                if(dictionary.containsKey(msg.substring(0,i))) {
                    w = msg.substring(0,i);
                } else {
                    break;
                }
            }
            answer.add(dictionary.get(w));
            if(w.length() != msg.length()) {
                dictionary.put(msg.substring(0, w.length()+1), dictionaryIdx++);
            }
            msg = msg.substring(w.length());
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}