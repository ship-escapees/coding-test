public class 쿼드_압축_후_갯수세기 {
    class Solution {
        public static int[] solution(int[][] arr) {
            Count count = count(0, 0, arr.length, arr);
            return new int[]{count.zero, count.one};
        }

        private static Count count(int offsetX, int offsetY, int size, int[][] arr){
            int h = size / 2;

            for (int x = offsetX; x < offsetX + size; x++){
                for (int y = offsetY; y < offsetY + size; y++){
                    if (arr[y][x] != arr[offsetY][offsetX]){
                        return count(offsetX, offsetY, h, arr)
                                .add(count(offsetX + h, offsetY, h, arr))
                                .add(count(offsetX, offsetY + h, h, arr))
                                .add(count(offsetX + h, offsetY + h, h, arr));
                    }
                }
            }

            if (arr[offsetY][offsetX] == 1){
                return new Count(0, 1);
            }

            return new Count(1,0);
        }

        private static class Count{
            public final int zero;
            public final int one;

            private Count(int zero, int one) {
                this.zero = zero;
                this.one = one;
            }

            public Count add(Count other){
                return new Count(zero + other.zero, one + other.one);
            }
        }
    }
}
