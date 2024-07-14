import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int n = order.length;
        
        for (int i = 1; i <= n; i++) {
            stack.push(i); // 기존 컨테이너 벨트에서 상자를 하나씩 꺼내 보조 컨테이너 벨트에 넣음

            // 보조 컨테이너 벨트의 맨 위 상자가 현재 실어야 할 상자와 일치하면 트럭에 싣음
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
            }
        }
        
        return index;
    }

}
