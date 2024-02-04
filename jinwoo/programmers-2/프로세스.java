import java.util.*;

class Solution {
   public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] counter = new int[9];
        //우선순위별 개수가 몇개인지 확인
        for (int i = 0; i < priorities.length; i++) counter[priorities[i]-1]++;

        //제네릭을 통해 Print 객체 타입의 Queue 생성
        Queue<Print> p = new LinkedList<>();
        //기존 인덱스와 우선순위 값을 Queue에 저장
        for (int i = 0; i < priorities.length; i++) p.add(new Print(i, priorities[i]));

        //우선순위가 높은 순서부터 counter 배열에 있는 수대로 체크하며 answer값에 ++ 하여 몇번째에 실행되는지 체크
        for (int i = 9; i >= 1; i--) {
            int j=0;
            while(j!=counter[i-1]) {
                if(p.peek().priority==i) {
                    answer++;
                    if(p.peek().index==location) {
                        return answer;
                    }
                    j++;
                }
                p.add(p.poll());
            }
        }
        return answer;
    }

    class Print {
        int index;
        int priority;

        public Print(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}