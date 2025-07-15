//memoization

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++) dp[i]=-1;
        return helper(0,nums,dp);
    }
    private int helper(int i,int[] nums,int[] dp){
        if(nums.length<=i) return 0;
        if(dp[i]!=-1) return dp[i];
        int rob=nums[i]+helper(i+2,nums,dp);
        int skip=helper(i+1,nums,dp);
        dp[i]=Math.max(rob,skip);
        return dp[i];
    }
}

//tabulation
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp=new int[n+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}

//space optimized
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int current=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}