import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        if ((sum1 + sum2) % 2 != 0) return -1; // 합이 홀수면 불가능

        long target = (sum1 + sum2) / 2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : queue1) q1.offer(num);
        for (int num : queue2) q2.offer(num);

        int maxOperations = queue1.length * 3; // 최대 연산 횟수
        int operations = 0;

        while (sum1 != target && operations <= maxOperations) {
            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                q2.offer(num);
                sum2 += num;
            } else {
                int num = q2.poll();
                sum2 -= num;
                q1.offer(num);
                sum1 += num;
            }
            operations++;
        }

        return sum1 == target ? operations : -1;
    }

}
