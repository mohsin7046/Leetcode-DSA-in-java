package Recursion_func;

public class Last_occurence {

    // public static int Last_App1(int key,int arr [] , int n){
    //     if(arr[n] == key){
    //         return n;
    //     }

    //     if(n <= 0){
    //         return -1;
    //     }

    //     return Last_App1(key, arr, n-1);
    // }

    public static int Last_App2(int key,int arr [], int n){

        if(n == arr.length) {return -1;}

       int isFound = Last_App2(key, arr, n+1);   //For looking forward for the same element

        if(isFound == -1 && arr[n] == key){
            return n;
        }

        return isFound;
    }


    public static void main(String[] args) {
        int key = 5;
        int arr [] = {5,5,5,5};
        // int n =  arr.length-1;    for App1
        int n =0;                // for App2

        // System.out.println(Last_App1(key,arr,n));
        System.out.println(Last_App2(key,arr,n));

    }
}
