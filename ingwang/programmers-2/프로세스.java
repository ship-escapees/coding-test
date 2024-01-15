import java.util.*;

class Solution30 {
     public static int Solution30(int[] priorities, int location) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder()); 
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pQueue.add(priorities[i]);
        }
        while(!pQueue.isEmpty()){
            for (int i = 0; i < priorities.length; i++) {
                if(pQueue.peek()==priorities[i]){
                    pQueue.poll();
                    answer++;

                    if (location==i){
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

      public static void main(String[] args) {
        int[] a = new int[]{1,22};

        System.out.println(Solution30(a,1));
    }
}
