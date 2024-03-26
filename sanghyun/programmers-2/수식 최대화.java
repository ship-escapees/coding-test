import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Long> nowNumList;
    List<String> nowOperList;
    public long solution(String expression) {
        String[][] s = {{"+", "-", "*"},{"+", "*", "-"},{"-", "+", "*"},{"-", "*", "+"},{"*", "-", "+"},{"*", "+", "-"}};
        List<Long> numList = new ArrayList<>();
        List<String> operList = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                numList.add(Long.valueOf(num.toString()));
                operList.add(String.valueOf(c));
                num = new StringBuilder();
            }else{
                num.append(c);
            }
        }
        numList.add(Long.valueOf(num.toString()));

        long max = 0;
        for (int i = 0; i < 6; i++) {
            String[] oper = s[i];
            nowNumList = new ArrayList<>();
            nowOperList = new ArrayList<>();
            nowNumList.addAll(numList);
            nowOperList.addAll(operList);

            for (int j = 0; j < oper.length; j++) {
                while (nowOperList.contains(oper[j])){
                    int idx = nowOperList.indexOf(oper[j]);
                    long num1 = nowNumList.get(idx);
                    long num2 = nowNumList.get(idx+1);

                    solve(num1,num2,idx, oper[j]);
                    nowNumList.remove(idx+1);
                    nowOperList.remove(idx);
                }
            }
            max = Math.max(Math.abs(nowNumList.get(0)),max);
        }
        
        return max;
    }
    protected void solve (long num1, long num2, int idx,String s){
        if(s.equals("*")){
            nowNumList.set(idx, nowNumList.get(idx) * nowNumList.get(idx+1));
        }else if (s.equals("+")){
            nowNumList.set(idx, nowNumList.get(idx) + nowNumList.get(idx+1));
        }else{
            nowNumList.set(idx, nowNumList.get(idx) - nowNumList.get(idx+1));
        }
    }
}
