import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};
    public int solution(String dirs) {
        int answer = 0;
        int[] now = {0,0};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int d = 0;
            if(c == 'U'){
                d = 2;
            } else if (c == 'L') {
                d = 1;
            } else if (c == 'D') {
                d = 3;
            }
            int[] next = {now[0]+x[d],now[1]+y[d]};
            if(next[0] > 5 || next[1] > 5 || next[0] < -5 || next[1] < -5){
                continue;
            }
            String[] input = {Arrays.toString(now) + Arrays.toString(next), Arrays.toString(next) + Arrays.toString(now)};
            if(!set.contains(input[0]) && !set.contains(input[1])){
                set.add(input[0]);
            }
            now = next;
        }
        answer = set.size();
        return answer;
    }
}
