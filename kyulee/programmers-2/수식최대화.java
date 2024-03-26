import java.util.*;

class 수식최대화 {
    static char[] operators = {'+', '-', '*'};
    static List<Character> operatorList = Arrays.asList('+', '-', '*');
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> operatorsList = new ArrayList<>();
    static ArrayList<Long> numbersTemp = new ArrayList<>();
    static ArrayList<Character> operatorsTemp = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static long answer;

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operatorsList.add(ch);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));

        permutation(0, new char[3]);

        return answer;
    }

    static long calculate(ArrayList<Long> numbers, ArrayList<Character> operators, char[] priority) {
        numbersTemp.clear();
        operatorsTemp.clear();
        numbersTemp.addAll(numbers);
        operatorsTemp.addAll(operators);

        for (char op : priority) {
            for (int i = 0; i < operatorsTemp.size(); i++) {
                if (operatorsTemp.get(i) == op) {
                    long num1 = numbersTemp.remove(i);
                    long num2 = numbersTemp.remove(i);
                    char oper = operatorsTemp.remove(i);
                    long result = calculate(num1, num2, oper);
                    numbersTemp.add(i, result);
                    i--;
                }
            }
        }

        return Math.abs(numbersTemp.get(0));
    }

    static long calculate(long num1, long num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }

    static void permutation(int depth, char[] priority) {
        if (depth == 3) {
            long result = calculate(numbers, operatorsList, priority);
            answer = Math.max(answer, result);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = operators[i];
                permutation(depth + 1, priority);
                visited[i] = false;
            }
        }
    }
}