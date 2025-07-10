class Solution {
    public int minFlips(int a, int b, int c) {
        int flip=0;
        while(a>0||b>0||c>0){
            int bitA=a&1;
            int bitB=b&1;
            int bitC=c&1;
            if((bitA | bitB)!=bitC){
                if(bitC==1){
                    flip+=1;
                }else{
                    if(bitA==1) flip+=1;
                    if(bitB==1) flip+=1;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return flip;
    }
}