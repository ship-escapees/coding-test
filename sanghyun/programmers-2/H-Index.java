import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        // 순번과 인용 수를 비교해서 숫자가 같아지거나 비교했을때 인용 수 >= 논문 개수 일경우 h-index 추가
        for (int i = 0; i < citations.length; i++) {
            int l = citations.length - i;
            if(citations[i] >= l) {
                return l;
            }
        }
        return 0;
    }
}
