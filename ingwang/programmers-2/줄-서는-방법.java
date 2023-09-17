import java.util.ArrayList;
import java.util.List;

// 효율성 몇개 실패
class Solution12 {
    public static int[] solution12(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>(); 
        int num = 1;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            num *= i;
        }
        while(x<n){
            num/=n - x;
            answer[x]= list.remove((int)(k/num));
            x ++;
            k%=num;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution12(4, 13));
    }
}