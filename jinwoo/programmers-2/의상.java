import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> h = new HashMap<>();
        //HashMap에 옷의 종류별로 카운트를 세는 반복문 수행
        for (int i = 0; i < clothes.length; i++) {
            h.put(clothes[i][1], h.getOrDefault(clothes[i][1], 0)+1);
        }
        
        if(h.size()>1) {
            //옷의 종류가 a, b, c 인 경우 각각 종류의 옷의 개수에 안입는 경우의수를 더해서 곱해주고, 아예 안입는 경우의 수를 빼주면(-1) answer값이 나옴
            int temp=1;
            for (Integer key : h.values()) {
                temp*=(key+1);
            }
            answer=temp-1;
        } else {
            //옷의 종류가 1가지인 경우는 clothes의 길이 만큼이 경우의 수
            answer=clothes.length;
        }

        return answer;
    }
}