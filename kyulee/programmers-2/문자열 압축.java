

public class 문자열 압축{
    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            int resultCount = compression(s, i);

            if (min > resultCount) {
                min = resultCount;
            }
        }

        return min;
    }

    private static int compression(String s, int idx) {

        StringBuilder builder = new StringBuilder();

        String before = "";
        int count = 0;

        for (String i : splitString(s, idx)) {
            if (i.equals(before)) {
                count++;
            } else {
                if (count > 0) {
                    count++;
                    builder.append(count + before);
                    count = 0;
                } else {
                    builder.append(before);
                }
                before = i;
            }
        }

        if (count > 0){
            builder.append(count + before);
        } else {
            builder.append(before);
        }

        return builder.length();
    }

    private static String[] splitString(String s, int idx) {

        String[] answer = new String[(s.length() / idx) + 1];

        int startIdx = 0;
        int endIdx = idx;


        for (int i = 0; i < answer.length; i++){

            if (endIdx > s.length()){
                endIdx = s.length();
            }

            answer[i] = s.substring(startIdx, endIdx);
            startIdx = endIdx;
            endIdx = endIdx + idx;
        }

        return answer;
    }
}