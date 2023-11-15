import java.util.*;
class Solution {
    //유클리드 호제법 사용
    public int solution(int[] arr) {
        //answer값 초기설정
        int answer = arr[0];

        //arr의 길이대로 반복문을 돌려서 앞의 값과 다음 값을 비교하여 최대공약수, 최대공배수를 구함
        for (int i = 1; i < arr.length; i++) {
            int gcb = gcb(answer, arr[i]);
            // a*b == 최대공약수*최소공배수 이기 때문에 a*b/gcb는 최소공배수이다.
            answer = answer*arr[i]/gcb;
        }
        return answer;
    }

    public int gcb(int a, int b) {
        int r = a%b;
        //a%b 가 0인 경우 b는 a와 b의 최대공배수
        if (r==0) return b;
        //재귀함수 호출하여 두수를 나눴을 때 나머지가 0인 값(최대공배수)를 찾는다.
        else return gcb(b, r);
    }
}