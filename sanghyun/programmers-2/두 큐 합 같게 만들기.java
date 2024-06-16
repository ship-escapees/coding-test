import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];

        }
        int maxCnt = queue1.length*3;

        while (sum1 != sum2){
            maxCnt--;
            if(sum1 > sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                answer++;
            }else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
                answer++;
            }
            if(maxCnt == 0) return -1;
        }
        return answer;
    }
}
