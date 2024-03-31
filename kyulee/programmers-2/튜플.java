import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        // 문자열 파싱을 위한 전처리
        s = s.substring(2, s.length() - 2).replace("},{", "-");

        // '-'를 기준으로 문자열을 나누어 배열에 저장
        String[] tuples = s.split("-");

        // 길이순으로 정렬
        Arrays.sort(tuples, Comparator.comparingInt(String::length));

        List<Integer> answerList = new ArrayList<>();

        for (String tuple : tuples) {
            String[] elements = tuple.split(",");

            for (String element : elements) {
                int num = Integer.parseInt(element);

                if (!answerList.contains(num)) {
                    answerList.add(num);
                }
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}