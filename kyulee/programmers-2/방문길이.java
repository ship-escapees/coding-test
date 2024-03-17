import java.util.HashSet;
import java.util.Set;


public class 방문길이 {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>(); // 방문한 좌표를 저장할 Set
        int[] dx = {0, 0, 1, -1}; // 각 명령어에 따른 x축 이동량
        int[] dy = {1, -1, 0, 0}; // 각 명령어에 따른 y축 이동량
        int x = 0, y = 0; // 현재 위치

        for (char move : dirs.toCharArray()) {
            int nx = x + dx[getIndex(move)]; // 다음 x좌표 계산
            int ny = y + dy[getIndex(move)]; // 다음 y좌표 계산

            // 좌표평면의 경계를 넘어가는 명령어는 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 캐릭터가 처음 걸어본 길을 집합에 추가
            visited.add(x + "" + y + "" + nx + "" + ny);
            visited.add(nx + "" + ny + "" + x + "" + y);

            x = nx; // 현재 위치 갱신
            y = ny;
        }

        return visited.size() / 2; // 처음 걸어본 길의 길이는 집합 크기의 절반
    }

    private int getIndex(char move) {
        if (move == 'U') return 0;
        else if (move == 'D') return 1;
        else if (move == 'R') return 2;
        else return 3; // 'L'
    }
}