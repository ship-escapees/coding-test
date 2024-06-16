import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            // 큐를 LinkedList로 변환
            Queue<Long> q1 = new LinkedList<>();
            Queue<Long> q2 = new LinkedList<>();
            long sum1 = 0, sum2 = 0;

            for (int num : queue1) {
                q1.add((long) num);
                sum1 += num;
            }

            for (int num : queue2) {
                q2.add((long) num);
                sum2 += num;
            }

            long totalSum = sum1 + sum2;
            // 두 큐의 총합이 홀수라면 균등 분할이 불가능하므로 -1 반환
            if (totalSum % 2 != 0) {
                return -1;
            }

            long target = totalSum / 2;
            int maxOperations = (queue1.length + queue2.length) * 2;
            int operations = 0;

            // 투 포인터 접근법을 사용하여 큐의 합을 조정
            while (sum1 != target && operations <= maxOperations) {
                if (sum1 > target) {
                    long num = q1.poll();
                    sum1 -= num;
                    q2.add(num);
                    sum2 += num;
                } else {
                    long num = q2.poll();
                    sum2 -= num;
                    q1.add(num);
                    sum1 += num;
                }
                operations++;
            }

            // 작업이 목표값을 달성하면 횟수 반환, 그렇지 않으면 -1 반환
            return (sum1 == target) ? operations : -1;
        }
    }

}
