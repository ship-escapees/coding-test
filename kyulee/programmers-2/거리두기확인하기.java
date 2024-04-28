public class 거리두기확인하기 {
    int[] dx = {0, -1, 1, 0};
    int[] dy = {-1, 0, 0, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }


    // 1. 해당 룸이 규칙을 지키고 있는지 판단하는 메서드
    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    // 2. 해당 대기실에서 현재 위치의 대기자가 거리두기를 지키고있는지 판단하는 메서드
    private boolean isDistanced(char[][] room, int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;


            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if(isNextToVolunteer(room,x,y,3-d)) return false;
                    break;
            }

        }
        return true;
    }


    // 3. 0인 파티션이 있을 경우 그 근처에 다른 응시자가 있는지 판단하는 메서드
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for (int d=0; d < 4; d++){
            if ( d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            if (room[ny][nx] == 'P')
                return true;
        }
        return false;
    }
}
