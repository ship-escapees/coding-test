import java.util.HashMap;

class Solution27 {
    public static int solution27(String[][] clothes) {
        int answer = 1;
        HashMap<String , Integer> hashmap = new HashMap<>();
        int num = 0;
        for (int i = 0; i < clothes.length; i++) {
            if(hashmap.containsKey(clothes[i][1])){
                num = hashmap.get(clothes[i][1]);
                hashmap.put(clothes[i][1], num+1);
            }else{
                hashmap.put(clothes[i][1], 1);
            }
        }

        for (String key : hashmap.keySet()){
            answer *= hashmap.get(key)+1;
        }
        answer-=1;
        return answer;
    }

    public static void main(String[] args) {
        String[][] a = new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution27(a));
    }
}