
import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    class Solution {
        public int solution(int[] priorities, int location) {
            Queue<Integer> queue = new LinkedList<>();

            for (int priority : priorities) {
                queue.offer(priority);
            }

            int answer = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                boolean isPrinted = true;

                for (int element : queue) {
                    if (current < element) {
                        isPrinted = false;
                        break;
                    }
                }

                if (isPrinted) {
                    answer++;

                    if (location == 0) {
                        break;
                    } else {
                        location--;
                    }
                } else {
                    queue.offer(current);

                    if (location == 0) {
                        location = queue.size() - 1;
                    } else {
                        location--;
                    }
                }
            }

            return answer;
        }
    }

    public class Main {
        public static void main(String[] args) {
            Solution solution = new Solution();

            // 예시 테스트
            int[] priorities1 = {2, 1, 3, 2};
            int location1 = 2;
            System.out.println(solution.solution(priorities1, location1));  // 1

            int[] priorities2 = {1, 1, 9, 1, 1, 1};
            int location2 = 0;
            System.out.println(solution.solution(priorities2, location2));  // 5
        }
    }
}
