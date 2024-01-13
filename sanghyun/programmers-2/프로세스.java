import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] p, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : p) q.offer(i);


        while (!q.isEmpty()) {
            for (int i = 0; i < p.length; i++){
                if(q.peek() == p[i]) {
                    q.poll();
                    answer++;

                    if(location == i || q.isEmpty()){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
