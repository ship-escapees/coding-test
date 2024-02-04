import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {

        int n = 0;
        int check = 26;
        int M = msg.length();

        msg += "xx";

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Integer> code = new ArrayList<Integer>();

        for(int inx = 0; inx < check; inx++) {
            map.put(Character.toString((char)(inx + 'A')), inx + 1);
        }

        for(int inx = 0; inx < M; inx++) {
            n = 1;
            while(map.containsKey(msg.substring(inx, inx + n))) {
                n++;
            }
            code.add(map.get(msg.substring(inx, inx + n - 1)));
            map.put(msg.substring(inx, inx + n), ++check);
            inx += (n - 2);
        }

        int L = code.size();
        int[] answer = new int[L];
        for(int inx = 0; inx < L; inx++) {
            answer[inx] = code.get(inx);
        }

        return answer;
    }
}
