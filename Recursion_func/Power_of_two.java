package Recursion_func;

public class Power_of_two {

    public static boolean Power(int n){
        double x = n / 2;
        System.out.println(x);
        if(x != 1 && n !=1){
            Power((int)x);
        }
        return true;
       
    }

    public static void main(String[] args) {
       
        int n = 3;
       
        System.out.println(Power(n));
    }
    
}
