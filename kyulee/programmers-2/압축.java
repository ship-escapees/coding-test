import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public static int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();

        // 사전 초기화
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            dictionary.put(String.valueOf(c), i + 1);
        }

        int nextIndex = 27; // 다음에 추가될 단어의 인덱스

        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < msg.length()) {
            endIndex = startIndex + 1;
            while (endIndex <= msg.length() && dictionary.containsKey(msg.substring(startIndex, endIndex))) {
                endIndex++;
            }
            endIndex--;

            // 사전에서 가장 긴 문자열 w를 찾고 해당 색인 번호를 결과에 추가
            result.add(dictionary.get(msg.substring(startIndex, endIndex)));

            // 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록
            if (endIndex < msg.length()) {
                dictionary.put(msg.substring(startIndex, endIndex + 1), nextIndex);
                nextIndex++;
            }

            // 다음 처리할 시작 인덱스를 설정
            startIndex = endIndex;
        }

        // 결과를 int 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] answer = solution(msg);
    }
}
