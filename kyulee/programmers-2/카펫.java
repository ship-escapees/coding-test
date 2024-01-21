
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        // 가로 길이의 후보
        for (int width = 3; width <= total / 3; width++) {
            if (total % width == 0) {
                int height = total / width;

                // 갈색 격자의 수가 맞는지 확인
                int brownCount = (width * 2) + (height * 2) - 4;
                if (brownCount == brown) {
                answer[0] = Math.max(width, height); // 가로 길이가 더 긴 값
                answer[1] = Math.min(width, height); // 세로 길이가 더 짧은 값
                break;
                }
            }
        }

        return answer;
        }
}
