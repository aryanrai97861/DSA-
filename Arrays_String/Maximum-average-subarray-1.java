class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum=0;
        for(int i=0;i<k;i++){
            maxSum+=nums[i];
        }
        double slidingWindow=maxSum;
        for(int i=k;i<nums.length;i++){
            slidingWindow+=nums[i]-nums[i-k];
            maxSum=Math.max(maxSum,slidingWindow);
        }
        return maxSum/k;
    }
}