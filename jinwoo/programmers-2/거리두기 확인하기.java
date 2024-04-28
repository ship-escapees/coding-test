class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean checkRoom(String[] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i].charAt(j) == 'P') {
                    if (!isSafe(room, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isSafe(String[] room, int x, int y) {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx].charAt(ny) == 'P') {
                    if (i < 4) {
                        return false;
                    } else { 
                        if (i == 4) {
                            if (room[x - 1].charAt(y) != 'X' || room[x].charAt(y - 1) != 'X') {
                                return false;
                            }
                        } else if (i == 5) {
                            if (room[x - 1].charAt(y) != 'X' || room[x].charAt(y + 1) != 'X') {
                                return false;
                            }
                        } else if (i == 6) {
                            if (room[x + 1].charAt(y) != 'X' || room[x].charAt(y - 1) != 'X') {
                                return false;
                            }
                        } else if (i == 7) {
                            if (room[x + 1].charAt(y) != 'X' || room[x].charAt(y + 1) != 'X') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * 2;
            int ny = y + dy[i] * 2;
            
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                if (room[nx].charAt(ny) == 'P') {
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (room[mx].charAt(my) != 'X') {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}