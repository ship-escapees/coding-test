import java.util.HashMap;
import java.util.Map;

class Solution {
            public int solution(String dirs) {
        int answer = 0;
        int[] point = {0, 0};
        Map<String, Integer> recode = new HashMap<>();

        String[] dirsArray = dirs.split("");
        for(String dir : dirsArray) {
            String checkPoint;
            int[] currentPoint = new int[]{point[0], point[1]};
            moving(point, dir);
            if (currentPoint[0] == point[0] && currentPoint[1] == point[1]) continue;
            if (dir.equals("L") || dir.equals("D")) {
                checkPoint = String.valueOf(point[0])+String.valueOf(point[1])+String.valueOf(currentPoint[0])+String.valueOf(currentPoint[1]);
            } else {
                checkPoint = String.valueOf(currentPoint[0])+String.valueOf(currentPoint[1])+String.valueOf(point[0])+String.valueOf(point[1]);
            }

            if(!recode.containsKey(checkPoint)) {
                answer++;
                recode.put(checkPoint, 1);
            }
        }


        return answer;
    }

    public int[] moving (int[] point, String move) {

        switch (move) {
            case "U":
                if(point[1] < 5) point[1]++;
                break;
            case "D":
                if(point[1] > -5) point[1]--;
                break;
            case "L":
                if(point[0] > -5) point[0]--;
                break;
            case "R":
                if(point[0] < 5) point[0]++;
        }
        return point;
    }
}