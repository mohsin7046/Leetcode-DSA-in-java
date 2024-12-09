package HeapANDPriorityQueue;

import java.util.PriorityQueue;

public class SlidingWindow {

    public static class Pair implements Comparable<Pair>{
        int value;
        int index;

        public Pair(int value,int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.value - this.value; // for descending order
        }
    }

    public static void main(String[] args) {
        //TC: --> O(NlogK)
        int window [] = {1,-1};
        int k = 1;
        PriorityQueue<Pair> p = new PriorityQueue<>();
        int arr [] = new int[window.length - k + 1];

        //add kth element in PQ
        for (int i = 0; i < k; i++) {
            p.add(new Pair(window[i], i));
        }

        //store first maximun from the PQ
        arr[0] = p.peek().value;

        for (int i = k; i < window.length; i++) {
            while (p.size() > 0 && p.peek().index <= (i-k)) {
                p.remove();
            }
            p.add(new Pair(window[i], i));
            arr[i-k+1] =p.peek().value; 
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
