//tabulation
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int oneStepCost = 0;
            if (i + 1 <= n) {
                oneStepCost = cost[i] + dp[i + 1];
            }
            int twoStepCost = 0;
            if (i + 2 <= n) {
                twoStepCost = cost[i] + dp[i + 2];
            }else{
                twoStepCost=cost[i];
            }
            dp[i] = Math.min(oneStepCost, twoStepCost);
        }
        return Math.min(dp[0], dp[1]);
    }
}

//Space optimized
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int downOne=0;
        int downTwo=0;
        for(int i=n-1;i>=0;i--){
            int current=cost[i]+Math.min(downOne,downTwo);
            downOne=downTwo;
            downTwo=current;
        }
        return Math.min(downOne,downTwo);
    }
}