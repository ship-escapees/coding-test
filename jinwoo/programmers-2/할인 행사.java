import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wantList = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                wantList.add(want[i]);
            }
        }
        Collections.sort(wantList);

        for (int i = 0; i < discount.length-9; i++) {
            String[] tempArr = new String[10];
            for (int j = 0; j < 10; j++) {
                tempArr[j] = discount[i+j];
            }
            Arrays.sort(tempArr);

            boolean check = true;
            for (int j = 0; j < tempArr.length; j++) {
                if(!wantList.get(j).equals(tempArr[j])) {
                    check=false;
                    break;
                }
            }
            if(check) {
                answer++;
            }
        }
        return answer;
    }
}