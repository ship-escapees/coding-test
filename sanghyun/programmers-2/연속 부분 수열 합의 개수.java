import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        int answer = 0;
        set = new HashSet<>();
        sum(elements,1,elements.length);
        return set.size();
    }
    public void sum(int[] list, int idx, int l){
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = 0; j < idx; j++) {
                if(j+i >= l){
                    sum += list[j+i-l];
                }else{
                    sum += list[j+i];
                }
            }
            set.add(sum);
        }
        if(idx == l){
            return;
        }
        sum(list,idx+1,l);
    }
}
