
import java.util.*;

public class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create pairs of (nums1[i], nums2[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort pairs by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        // Min-heap to keep top k nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, maxScore = 0;

        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];

            minHeap.add(num1);
            sum += num1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();  // Remove the smallest nums1
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;
    }
}
