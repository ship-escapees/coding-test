import java.util.*;


class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] answer = new int[n];
        long[] factorial = new long[n + 1];
        calculateFactorial(factorial);

        // k를 인덱스 기준으로 변환
        k--;

        for (int i = 0; i < n; i++) {
            // 남은 사람들의 수
            int peopleCnt = n - i - 1;

            // 현재 자리에 올 수 있는 경우의 수 (남은 사람들의 팩토리얼)
            long idxCase = factorial[peopleCnt];

            // 현재 자리에 올 수 있는 사람의 인덱스 계산
            int idxValue = (int) (k / idxCase);

            // 정답 배열에 추가하고 해당 번호 제거
            answer[i] = numbers.get(idxValue);
            numbers.remove(idxValue);

            // 다음 자리로 넘어갈 때, k 값 갱신
            k %= idxCase;
        }

        return answer;
    }

    private void calculateFactorial(long[] factorial) {
        factorial[0] = 1;

        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}