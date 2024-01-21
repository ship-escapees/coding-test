

public class h-index{
    public static int solution(int[]citations)
        {
            int hIdx=0;
            Arrays.sort(citations);

            int cSize=citations.length;
            int maxIdx=citations[cSize-1];

            for(int i=0;i<maxIdx; i++){
                // 참조 된 수
                int x=0;

                for(int j=0;j<cSize; j++){
                    if(i<citations[j]){
                        x++;
                    }
                }

             if(i==x){
                 hIdx=i;
                 break;
                }
            }

        return hIdx;
    }
}
