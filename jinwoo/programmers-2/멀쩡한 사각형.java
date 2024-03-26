public class Solution {
    public long solution(int w, int h) {
        long total = (long) w * (long) h; // 전체 정사각형의 수
        long unusable = (long) w + (long) h - gcd(w, h); // 사용할 수 없는 정사각형의 수
        return total - unusable; // 사용할 수 있는 정사각형의 수
    }

    // 최대공약수를 구하는 메소드
    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}