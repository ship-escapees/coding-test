package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class 예상-대진표 {
    public static int solution(int n, int a, int b)
    {
        int round = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 참가자 번호를 큐에 추가
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 각 라운드에서의 게임 진행
        while (queue.size() > 1) {
            round++;

            // 현재 라운드에서의 게임 수행
            int size = queue.size();
            for (int i = 0; i < size; i += 2) {
                int player1 = queue.poll();
                int player2 = queue.poll();

                // A와 B가 만났을 때
                if ((player1 == a && player2 == b) || (player1 == b && player2 == a)) {
                    return round;
                }

                // 다음 라운드에 진출하는 참가자를 큐에 추가
                if (player1 == a || player1 == b) {
                    queue.add(player1);
                } else if (player2 == a || player2 == b) {
                    queue.add(player2);
                } else {
                    queue.add(player1);
                }
            }
        }

        // 만약 여기까지 왔다면 A와 B가 만날 일이 없었으므로 예외처리
        return -1;

    }

    public static void main(String[] args) {
        int result = solution(8,4,7);
        System.out.println(result);
    }
}
