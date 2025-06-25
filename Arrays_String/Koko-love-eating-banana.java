class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = getMax(piles);
        long result = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long neededHours = hoursNeeded(piles, mid);
            if (neededHours <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) result;
    }

    private long getMax(int[] piles) {
        long max = 0;
        for (long pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private long hoursNeeded(int[] piles, long k) {
        long hours = 0;
        for (long pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours;
    }
}