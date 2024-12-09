package HeapANDPriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public  class Basic_Heap {
    public static class Heap
   {
     ArrayList<Integer>list = new ArrayList<>();

    

    public  void add( int val){
        list.add(val);  //step:1 Add at last index

        //step:2 Now compare with it's parent until child < parent
        //parent-index = (childindex - 1) / 2
        int x = list.size() -1;
        int parentidx = (x - 1) / 2;

        while(list.get(x) < list.get(parentidx)){   //O(logn)
            //swap
            int temp = list.get(x);
            list.set(x, list.get(parentidx));
            list.set(parentidx, temp);

            x = parentidx;
            parentidx = (x-1) / 2;
        }
    }

    public int peek(){
        return list.get(0);
    }

    public  int delete(){
    int data = list.get(0);
    //step:1 Swap with last element 
    int temp = list.get(0);
    list.set(0, list.get(list.size()-1));
    list.set(list.size()-1, temp);

    //step:2
    list.remove(list.size()-1);  //delete last element

    //step:3 ---> Heapify(fix the heap)
     heapify(0);

     return data;
    }


    public  void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        // int minIdx = i;
        int maxIdx = i;


        if(left < list.size() && list.get(maxIdx) < list.get(left)){
            
            maxIdx = left;
        }

        if(right < list.size() && list.get(maxIdx) < list.get(right))
        {
            maxIdx = right;
        }

        if(maxIdx != i) {   // if minIdx == i no need to swap
            int temp = list.get(i);
           list.set(i, list.get(maxIdx));
           list.set(maxIdx, temp);

        heapify(maxIdx);
        }
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }


}

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(5);
        pq.add(3);
        pq.add(2);
        pq.add(10);
        pq.add(1);

        pq.heapSortMaxHeap();
    
        while (!pq.isEmpty()) {   //Heap Sort
            System.out.println(pq.peek());
            pq.delete();
        }

    }
}
