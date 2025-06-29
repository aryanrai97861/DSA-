
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null || digits.isEmpty()) return result;
        backtrack(result,new StringBuilder(),0,digits);
        return result;
    }
    private static final String[] KEYPAD={
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    private void backtrack(List<String> result,StringBuilder current,int index,String digits){
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }
        String letters=KEYPAD[digits.charAt(index)-'0'];
        for(char letter:letters.toCharArray()){
            current.append(letter);
            backtrack(result,current,index+1,digits);
            current.deleteCharAt(current.length()-1);
        }
    }
}