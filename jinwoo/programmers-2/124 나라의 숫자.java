public class Solution{
    public String solution(int n) {
        String answer = "";
        //효율성 검사 통과 및 시간 단축을 위해 StringBuilder() 사용
        StringBuilder st = new StringBuilder();
        while(n>=3) {
            int num;
            if(n%3 == 0) {
                num=4;
                n=(n/3)-1;
            } else {
                num=n%3;
                n=(n/3);
            }
            //ex) StringBuilder.insert([Index], [addString]);
            st.insert(0, num);
        }
        if(n!=0) {
            st.insert(0, n);
        }
        //StringBuilder 형변환하여 String에 대입
        answer=st.toString();
        return answer;
    }
}