import java.util.*;

public class Solution {
    static int maxDiff = Integer.MIN_VALUE;  // 최대 점수 차이
    static int[] bestShot = new int[11];     // 최적의 화살 배열
    static int[] lion;                       // 라이언의 화살 배열
    static int[] apeach;                     // 어피치의 화살 배열

    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        apeach = info;
        dfs(n, 0);
        
        if (maxDiff == Integer.MIN_VALUE) {
            return new int[]{-1};
        }
        return bestShot;
    }

    private static void dfs(int n, int idx) {
        if (idx == 11) {
            if (n > 0) lion[10] += n;  // 남은 화살 모두 0점에 맞힘
            int lionScore = 0, apeachScore = 0;
            
            for (int i = 0; i < 11; i++) {
                if (lion[i] > apeach[i]) lionScore += 10 - i;
                else if (apeach[i] > 0) apeachScore += 10 - i;
            }
            
            int diff = lionScore - apeachScore;
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    bestShot = lion.clone();
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > bestShot[i]) {
                            bestShot = lion.clone();
                            break;
                        } else if (lion[i] < bestShot[i]) {
                            break;
                        }
                    }
                }
            }
            
            if (n > 0) lion[10] -= n;  // 원상복구
            return;
        }
        
        if (n > apeach[idx]) {  // 어피치보다 많이 맞힐 수 있는 경우
            lion[idx] = apeach[idx] + 1;
            dfs(n - lion[idx], idx + 1);
            lion[idx] = 0;  // 원상복구
        }
        
        dfs(n, idx + 1);  // 해당 점수에 화살을 안 쏘는 경우
    }
}
