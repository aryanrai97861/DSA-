class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int max=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                k--;
            }
            if(k<0){
                if(nums[left]==0){
                    k++;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}