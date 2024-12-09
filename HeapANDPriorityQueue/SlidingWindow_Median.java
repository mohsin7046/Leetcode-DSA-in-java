package HeapANDPriorityQueue;

import java.util.*;

public class SlidingWindow_Median {

    public static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        // TC: --> O(NlogK)
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 1;
        PriorityQueue<Pair> largepq = new PriorityQueue<>();
        PriorityQueue<Pair> smallpq = new PriorityQueue<>((a, b) -> b.val - a.val);
        int arr[] = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            smallpq.add(new Pair(nums[i], i));
        }

        for (int i = 0; i < k / 2; i++) {
            largepq.add(smallpq.poll());
        }

        // median
        if (k % 2 == 0) {
            arr[0] = smallpq.peek().val;
        } else {
            arr[0] = ((double) smallpq.peek().val + largepq.peek().val) / 2;
        }

        // store first maximun from the PQ
        arr[0] = p.peek().value;

        for (int i = k; i < nums.length; i++) {
            while (smallpq.size() > 0 && largepq.size() > 0 && smallpq.peek().index <= (i - k)) {
                p.remove();
            }
            p.add(new Pair(window[i], i));
            arr[i - k + 1] = p.peek().value;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
