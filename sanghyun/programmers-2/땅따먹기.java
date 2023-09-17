class Solution {
    int solution(int[][] land) {
        int answer = 0;  // 최종 결과로 반환할 값
        
        for (int i = 1; i < land.length; i++) {  // 행 탐색 (첫 번째 행은 무시)
            for (int j = 0; j < land[i].length; j++) {  // 열 탐색
                int max = 0;  // 이전 행에서 현재 열을 제외한 최대값 저장 변수
                for (int k = 0; k < land[i-1].length; k++) {  // 이전 행의 열들을 순회
                    if (k != j) {  // 현재 열을 제외한 경우에만
                        max = Math.max(max, land[i-1][k]);  // 최대값 갱신
                    }
                }
                land[i][j] = land[i][j] + max;  // 현재 위치에 최대값을 더하여 저장
            }
        }
        
        for (int i = 0; i < land[0].length; i++) {  // 마지막 행의 열을 순회
            answer = Math.max(answer, land[land.length-1][i]); 
        }
        return answer; 
    }
}
