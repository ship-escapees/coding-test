

public int 다음 큰 숫자(int n){
    int m=n;
    int answer=0;

    while(m>=n){

        String binaryStringNum=Integer.toBinaryString(n);
        String binaryStringResult=Integer.toBinaryString(m);

        int numToBinaryCnt=countOnes(binaryStringNum);
        int resultToBinaryCnt=countOnes(binaryStringResult);

        if(numToBinaryCnt==resultToBinaryCnt){
            answer=m;

            if(m>n){
            break;
            }
        }
        m++;
    }
    return answer;
}

private int countOnes(String binaryString){
    int count=0;

    for(int i=0;i<binaryString.length();i++){
        if(binaryString.charAt(i)=='1'){
            count++;
        }
    }

    return count;
}
