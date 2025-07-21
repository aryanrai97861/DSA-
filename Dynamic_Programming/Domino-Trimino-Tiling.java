class Solution {
    int MOD = 1_000_000_007;
    
    // Method 1: Memoization (Top-Down)
    public int numTilings(int n) {
        Integer[] memo = new Integer[n + 1];
        return memoization(n, memo);
    }
    
    private int memoization(int n, Integer[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != null) return memo[n];
        
        long ways = (2L * memoization(n - 1, memo)) % MOD;
        ways = (ways + memoization(n - 3, memo)) % MOD;
        
        return memo[n] = (int) ways;
    }
    
    // Method 2: Tabulation (Bottom-Up)
    public int numTilingsTabulation(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        
        return (int) dp[n];
    }
    
    // Method 3: Space Optimized
    public int numTilingsSpaceOptimized(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long dp0 = 1; // dp[i-3]
        long dp1 = 1; // dp[i-2]
        long dp2 = 2; // dp[i-1]
        
        for (int i = 3; i <= n; i++) {
            long current = (2 * dp2 + dp0) % MOD;
            
            // Shift values
            dp0 = dp1;
            dp1 = dp2;
            dp2 = current;
        }
        
        return (int) dp2;
    }
}

// Complete solution with all methods and test cases
class CompleteSolution {
    int MOD = 1_000_000_007;
    
    // Method 1: Memoization (Top-Down)
    // Time: O(n), Space: O(n) for memo + O(n) for recursion stack
    public int numTilingsMemo(int n) {
        Integer[] memo = new Integer[n + 1];
        return memoization(n, memo);
    }
    
    private int memoization(int n, Integer[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != null) return memo[n];
        
        long ways = (2L * memoization(n - 1, memo)) % MOD;
        ways = (ways + memoization(n - 3, memo)) % MOD;
        
        return memo[n] = (int) ways;
    }
    
    // Method 2: Tabulation (Bottom-Up)
    // Time: O(n), Space: O(n)
    public int numTilingsTabulation(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        
        return (int) dp[n];
    }
    
    // Method 3: Space Optimized
    // Time: O(n), Space: O(1)
    public int numTilingsSpaceOptimized(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long dp0 = 1; // dp[i-3]
        long dp1 = 1; // dp[i-2]
        long dp2 = 2; // dp[i-1]
        
        for (int i = 3; i <= n; i++) {
            long current = (2 * dp2 + dp0) % MOD;
            
            // Shift values for next iteration
            dp0 = dp1;
            dp1 = dp2;
            dp2 = current;
        }
        
        return (int) dp2;
    }
}