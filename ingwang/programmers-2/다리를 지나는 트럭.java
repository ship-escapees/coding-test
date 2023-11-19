import java.util.LinkedList;
import java.util.Queue;

class Solution28{
    public static int solution28(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total = 0;
        Queue<Integer> length = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            int seq = truck_weights[i];
            while (true) {

                if (length.isEmpty()){
                    length.add(seq);
                    total+=seq;
                    answer ++;
                    break;
                }else if(length.size()==bridge_length){
                    total -= length.poll();
                }else{
                    if(total+seq <=weight){
                        length.add(seq);
                        total += seq;
                        answer ++;
                        break;
                    }else{
                        length.add(0);
                        answer++;
                    }
                }
            }
            
        }


        return answer + bridge_length;
    }

    public static void main(String[] args) {

        int x= 2;
        int y =10;
        int [] a = new int[]{7,4,6,5};

        System.out.println(solution28(x,y,a));
    }
}