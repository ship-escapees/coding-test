class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCount = 0;
        
        String nBin = Integer.toBinaryString(n);
        //입력값 2진수로 변경하여 1의 개수가 몇개인지 카운트
        for (int i = 0; i < nBin.length(); i++) {
            if (nBin.charAt(i) == '1') {
                nCount++;
            }
        }

        while (true) {
            n++;
            String tempBin = Integer.toBinaryString(n);
            int tempCount = 0;
            //n의 값을 증가시키며 1의 개수를 체크
            for (int i = 0; i < tempBin.length(); i++) {
                if (tempBin.charAt(i) == '1') {
                    tempCount++;
                }
            }
            //기존 입력값을 이진수로 변경했을때의 1의 개수와 입력값을 증가시키며 이진수로 변경했을때의 1의 개수가 같으면 리턴
            if (nCount == tempCount) {
                answer = n;
                return answer;
            }
        }
    }
}