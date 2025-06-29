class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reverseNumber=reverse(x);
        return x==reverseNumber;
    }
    public int reverse(int x) {
        int revNum = 0;
        while (x != 0) {
            int digit = x % 10;

            // Check for overflow
            if (revNum > Integer.MAX_VALUE / 10 ) return 0;
            if (revNum < Integer.MIN_VALUE / 10 ) return 0;

            revNum = revNum * 10 + digit;
            x /= 10;
        }
        return revNum;
    }
}