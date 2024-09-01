import java.util.*;

// public class Array {


//     public static int Largest(int[] nums) { 

//         int largest = Integer.MIN_VALUE;       //If we get largest value initalize the variable with the Integer.MIN_VALUE

//         for(int i = 0;i<nums.length;i++){
//             if(nums[i] > largest){
//                 largest = nums[i];
//             }
//         }
//         return largest;
//     }

//     public static void main(String[] args) {
//         int nums [] = {1,2,4,6,8,3,9};
        
//          System.out.println("Largest value is "+ Largest(nums));
//     }
// }

// public class Array {


//     public static void Reverse(int [] arr){
//         int left =0;
//         int right = arr.length -1;

//         while(right > left){
//                 int temp = arr[left];
//                 arr[left]= arr[right];
//                 arr[right] = temp;
        
//             left ++;
//             right --;
//         }
//     }

//     public static void main(String[] args) {
//         int arr [] = {1,2,3,4,5,6};

//         Reverse(arr);

//         for(int i=0;i<arr.length;i++){
            
//         System.out.print(" " +arr[i]);
//         }

//     }
// }


// public class Array {

//     public static void Pair(int arr []){
//         for(int i = 0; i < arr.length; i++){
//             for(int j = i+1; j < arr.length; j++){

//                 System.out.print("("+arr[i]+","+arr[j]+")");
    
//             }
//         System.out.println("");
//         }
// }


//     public static void main(String[] args) {
//         int arr [] = {1,2,3,4,5,6};

//         Pair(arr);           //Total pairs: n*(n+1)/2
//     }
// }



