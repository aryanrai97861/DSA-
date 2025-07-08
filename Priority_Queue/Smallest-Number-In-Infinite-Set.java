import java.util.*;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> inHeap;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();

        // Add numbers 1 to 1000 because of the constraint
        for (int i = 1; i <= 1000; i++) {
            minHeap.offer(i);
            inHeap.add(i);
        }
    }

    public int popSmallest() {
        int smallest = minHeap.poll();
        inHeap.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if (!inHeap.contains(num)) {
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */