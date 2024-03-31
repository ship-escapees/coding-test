import java.util.ArrayList;
import java.util.List;

public class Solution {
    private long answer = 0;

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        String num = "";
        
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                numbers.add(Long.parseLong(num));
                ops.add(ch);
                num = "";
            } else {
                num += ch;
            }
        }
        numbers.add(Long.parseLong(num));

        char[] priorities = {'+', '-', '*'};
        boolean[] visited = new boolean[3];
        char[] output = new char[3];

        permuteAndCalculate(priorities, visited, output, 0, 3, numbers, ops);
        return answer;
    }

    private void permuteAndCalculate(char[] priorities, boolean[] visited, char[] output, int depth, int n, List<Long> numbers, List<Character> ops) {
        if (depth == n) {
            answer = Math.max(answer, Math.abs(calculate(numbers, ops, output)));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = priorities[i];
                permuteAndCalculate(priorities, visited, output, depth + 1, n, numbers, ops);
                visited[i] = false;
            }
        }
    }

    private long calculate(List<Long> numbers, List<Character> ops, char[] priority) {
        List<Long> nums = new ArrayList<>(numbers);
        List<Character> operations = new ArrayList<>(ops);

        for (char op : priority) {
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i) == op) {
                    long result = 0;
                    switch (op) {
                        case '+':
                            result = nums.get(i) + nums.get(i + 1);
                            break;
                        case '-':
                            result = nums.get(i) - nums.get(i + 1);
                            break;
                        case '*':
                            result = nums.get(i) * nums.get(i + 1);
                            break;
                    }
                    nums.remove(i + 1);
                    nums.set(i, result);
                    operations.remove(i);
                    i--;
                }
            }
        }

        return nums.get(0);
    }
}