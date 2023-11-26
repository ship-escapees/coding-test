
/*
  1. 상태
  - 옮기려는 원판의 갯수
  - 원판이 현재 위치한 기둥 from
  - 원판이 이동해야하는 기둥 to

  2. 종료 조건
  - (1, from, to) = [[from, to]]

  3. 점화식
 - 상태를 가장 작은 상태로 전이시켜줄 점화식
 - 원반 n개를 이동시키는 부분 문제는 원반 n-1개를 이동시키는 부분 문제로 해결할 수 잇다.
    (n, from, to) = (n-1, from, empty) + (1,from,to) + (n-1, empty, to)

 */

import java.util.ArrayList;
import java.util.List;

public class 하노이-탑 {
    public static int[][] solution(int n) {
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }

    private static List<int[]> hanoi(int n, int from, int to){
        if (n == 1) return List.of(new int[] {from, to});

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n-1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n-1, empty, to));
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] answer = solution(n);
    }
}
