class Solution {
    public int largestAltitude(int[] gain) {
        int max_altitude = 0;
        int curr_altitude = 0;
        for (int i = 0; i < gain.length; i++) {
            curr_altitude += gain[i];
            max_altitude = Math.max(max_altitude, curr_altitude);
        }
        return max_altitude;
    }
}