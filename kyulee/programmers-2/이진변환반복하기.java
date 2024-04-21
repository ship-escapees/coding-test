public class 이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            int cnt = 0;
            int remove = 0;
            String toBinary = s;

            while (true) {
                int cntOne = 0;

                if (toBinary.length() == 1) {
                    answer[0] = cnt;
                    answer[1] = remove;
                    break;
                }

                for (String a : toBinary.split("")) {
                    if (a.equals("0")) {
                        remove++;
                    } else if (a.equals("1")) {
                        cntOne++;
                    }
                }

                toBinary = Integer.toString(cntOne, 2);
                cnt++;
            }

            return answer;
        }
    }
}
