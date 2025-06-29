
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, 0, k, n);
        return result;
    }

    private final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int index, int currentSum, int k, int n) {
        if(temp.size()>k){
            return;
        }
        if(temp.size()==k && currentSum==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<array.length;i++){
            if(currentSum+array[i]>n){
                continue;
            }
            temp.add(array[i]);
            backtrack(result,temp,i+1,currentSum+array[i],k,n);
            temp.remove(temp.size()-1);
        }
    }
}
