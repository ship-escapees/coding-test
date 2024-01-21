import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    boolean[] check;
    Set<Integer> set;
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        set = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            addCase("", numbers, i);
        }
        int answer = 0;
        System.out.println(set);
        for (int num : set) {
            if(sosuCheck(num)) answer++;
        }
        return answer;
    }
    public void addCase(String temp, String numbers, int len) {
        if (temp.length() == len) {
            set.add(Integer.valueOf(temp));
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (check[i]) continue;

            check[i] = true;
            addCase(temp + numbers.charAt(i), numbers, len);
            check[i] = false;
        }
    }

    public boolean sosuCheck(int num){
        if(num <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0 || i*i==num) return false;
        }
        return true;
    }
}
