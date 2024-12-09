package HeapANDPriorityQueue;

public class HeapSort {

    public static void heapsort(int arr[]){   // ---> overall-O(nlogn)
        //step:1 Create Maxheap
        int n = arr.length;
        for (int i = n/2 ; i >= 0; i--) {  // for non-leap node  --> O(n/2 * logn)  == O(nlogn)
            heapify(arr,i,n);   
        }

        //step:2 push largest element at last
        for (int i = n-1; i > 0 ; i--) {  // --> O(nlogn)
            //swap(0,last)
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //call heapify for remaining heap
            heapify(arr,0,i);   // --> O(logn)
        }
    }

    public static void heapify(int arr[], int i , int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};

        heapsort(arr);      

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");   //ascending order: 1 2 3 4 5 
        }
    }
}
