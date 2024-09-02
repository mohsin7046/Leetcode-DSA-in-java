package Recursion_func;

public class Sum_NaturalNum {

    public static int Sum(int n){
        if(n==1){
            return 1;
        }else{
            return n+Sum(n-1);
        }
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(Sum(n));
    }
}
