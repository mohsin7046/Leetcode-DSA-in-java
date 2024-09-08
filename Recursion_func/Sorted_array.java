package Recursion_func;

public class Sorted_array {

    public static boolean Sorted(int arr [], int i){
        
        if(i == arr.length-1 ){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }

        return Sorted(arr, i+1);
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,9,6};
        int i =0;
        System.out.println(Sorted(arr,i));
    }
}
