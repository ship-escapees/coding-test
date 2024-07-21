import java.util.HashMap;

public class 추억점수 {
    public class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            // 이름과 그리움 점수를 매핑하는 HashMap 생성
            HashMap<String, Integer> yearningMap = new HashMap<>();
            for (int i = 0; i < name.length; i++) {
                yearningMap.put(name[i], yearning[i]);
            }

            // 각 사진의 추억 점수를 계산할 결과 리스트 생성
            int[] result = new int[photo.length];

            // 각 사진에 대해 추억 점수 계산
            for (int i = 0; i < photo.length; i++) {
                int memoryScore = 0;
                for (String person : photo[i]) {
                    memoryScore += yearningMap.getOrDefault(person, 0);
                }
                result[i] = memoryScore;
            }

            return result;
        }
    }
}

