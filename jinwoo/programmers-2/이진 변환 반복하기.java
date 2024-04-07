class Solution {
    public int[] solution(String s) {
        int[] answer;
        int zeroCount = 0;
        int count = 0;

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='0') {
                    zeroCount++;
                }
            }
            s=s.replaceAll("0","");
            String sTemp="";
            int sLength = s.length();
            while(sLength!=0) {
                sTemp = sLength%2 + sTemp;
                sLength/=2;
            }
            s = sTemp;
            count++;
        }
        answer = new int[]{count, zeroCount};
        return answer;
    }
}