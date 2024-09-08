package Backtraking;

public class BT_on_Array {

    public static void ChangeArr(int arr [],int i,int val){
        //Base case
        if(i == arr.length){
            PrintArray(arr);   // It will return the array before the return [1,2,3,4,5]
            return;
        }

        arr[i] = val;
        ChangeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;   //BackTrack It will work after recursion function hit the base case and return 
    }


    public static void PrintArray(int arr []){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr [] = new int [5];
        ChangeArr(arr,0,1);
       PrintArray(arr);    //It will return the array after then return(descrease by 2) [-1,0,1,2,3]
        
    }
}
