class Solution {
    public int maxVowels(String s, int k) {
        int maxSubString=0;
        int i=0;
        int j=0;
        int count=0;
        while(j<s.length()){
            if(checkVowels(s.charAt(j))){
                count++;
            }
            if((j+1)-i==k){
                maxSubString=Math.max(maxSubString,count);
                if(checkVowels(s.charAt(i))){
                    count--;
                }
                i+=1;
            }
            j+=1;
        }
        return maxSubString;
    }
    private boolean checkVowels(char ch){
        return ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u';
    }
}