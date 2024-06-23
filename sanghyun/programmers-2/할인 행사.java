import java.util.HashMap;
import java.util.Objects;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> wantMap = new HashMap<>();
        HashMap<String,Integer> discountMap =  new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i],number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if(discountMap.containsKey(discount[i])){
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i],0)+1);
            }else{
                discountMap.put(discount[i],1);
            }
        }

        for (int i = 10; i <= discount.length; i++) {
            boolean cheak = true;
            for (String s : want) {
                if (!Objects.equals(wantMap.get(s), discountMap.get(s))) {
                    cheak = false;
                }
            }
            if(cheak){
                answer++;
            }
            if(i == discount.length){
                break;
            }
            discountMap.put(discount[i-10],discountMap.getOrDefault(discount[i-10],0)-1);
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }
        return answer;
    }
}
