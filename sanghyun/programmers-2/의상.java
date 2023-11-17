import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        // answer = (의상수+1)*(의상수+1)*(의상수+1)-1; 이라고 한다.
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String costume = clothes[i][1];
            if(!map.containsKey(costume)){
                map.put(costume,1);
            } else {
                map.put(costume, map.getOrDefault(costume, 0)+1);
            }
        }
        for (Integer num : map.values()){
            answer *= (num+1);
        }
        return answer-1;
    }
}
