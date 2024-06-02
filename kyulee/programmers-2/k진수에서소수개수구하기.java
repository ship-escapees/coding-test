public class k진수에서소수개수구하기 {
    class Solution {
        public int solution(int n, int k) {
            String kBaseNumber = Integer.toString(n, k);
            String[] parts = kBaseNumber.split("0");

            int primeCount = 0;
            for (String part : parts) {
                if (!part.isEmpty() && isPrime(Long.parseLong(part))) {
                    primeCount++;
                }
            }

            return primeCount;
        }

        private boolean isPrime(long num) {
            if (num <= 1) return false;
            if (num == 2 || num == 3) return true;
            if (num % 2 == 0 || num % 3 == 0) return false;
            for (long i = 5; i * i <= num; i += 6) {
                if (num % i == 0 || num % (i + 2) == 0) return false;
            }
            return true;
        }
    }
}
