class Solution {
    public int compress(char[] chars) {
        int ans=0;
        int i=0;
        while(i<chars.length){
            char current=chars[i];
            int count=0;
            while(i<chars.length && chars[i]==current){
                i++;
                count++;
            }
            chars[ans++] = current;
            if(count>1){
                for (char c : String.valueOf(count).toCharArray()){
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}