
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            List<Integer> result=new ArrayList<>();
            List<Integer> indices=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(nums[j]==key){
                    indices.add(j);
                }
            }
            for(int i=0;i<nums.length;i++){
                for(int j:indices){
                    if(Math.abs(i-j)<=k){
                        result.add(i);
                        break;
                    }
                }
            }
            return result;
        
    }
}