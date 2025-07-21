class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + prev[j + 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }
            prev = curr.clone(); 
        }
        return prev[0];
    }
}