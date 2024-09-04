package Recursion_func;
public class First_Ocurrence {

    public static int First(int n,int arr []){
        int key = 8;
        if(arr[n] == key){
            return n;
        }
        
        if(n == arr.length-1){
            return -1;
        }
    
           return First(n+1, arr);


    }

    public static void main(String[] args) {
        int n = 0;
        int arr [] = {3,2,3,3,5,6,7,8};
        System.out.println(First(n,arr));
    }
}
