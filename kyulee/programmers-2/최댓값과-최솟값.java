
public class 최댓값과 최솟값 {
    /*
    이전에 파이썬으로 풀었던 풀이
        def solution(s):
        arr = list(map(int, s.split(' ')))
        return str(min(arr)) + " " + str(max(arr))
    */

    public static String solution(String s) {
        List<Integer> integerList = new ArrayList<>();

        for(String a : s.split(" ")){
            integerList.add(Integer.parseInt(a));
        }

        return Collections.min(integerList) + " " + Collections.max(integerList);
    }
}