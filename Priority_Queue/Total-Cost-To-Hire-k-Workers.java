
import java.util.PriorityQueue;


class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int i = 0;
        int j = n - 1;
        long totalCost = 0;
        //storing our workers
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        //putting our workers in the heap
        for (int count = 0; count < candidates && i <= j; count++) {
            leftHeap.offer(costs[i++]);
        }
        for (int count = 0; count < candidates && i <= j; count++) {
            rightHeap.offer(costs[j--]);
        }
        //hiring workers
        int left_min = Integer.MAX_VALUE;
        int right_min = Integer.MAX_VALUE;

        for (int hired = 0; hired < k; hired++) {
            if (!leftHeap.isEmpty()) {
                left_min = leftHeap.peek();
            } else {
                left_min = Integer.MAX_VALUE;
            }

            if (!rightHeap.isEmpty()) {
                right_min = rightHeap.peek();
            } else {
                right_min = Integer.MAX_VALUE;
            }
            //tie breaker
            if (left_min <= right_min) {
                totalCost += leftHeap.poll();
                if (i <= j) {
                    leftHeap.offer(costs[i++]);
                }
            } else {
                totalCost += rightHeap.poll();
                if (i <= j) {
                    rightHeap.offer(costs[j--]);
                }
            }
        }
        return totalCost;
    }
}
