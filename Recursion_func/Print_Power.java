package Recursion_func;

public class Print_Power {

    public static int Power(int n, int x){
    
        if(x == 0){
            return 1;
        }
        
        return n * Power(n, x-1);
    }


    //Optimized for Power- O(logn(n))

    public static int Optimized_Power(int n, int x){
        if(x == 0) return 1;

        int half_Power = Optimized_Power(n, x/2) ;
        half_Power = half_Power * half_Power;

        if(x % 2 != 0){
            half_Power = n * half_Power;
        }

        return half_Power;
    }

    public static void main(String[] args) {
       
        int n =2;
        int x = 5;
        System.out.println(Optimized_Power(n, x));
        System.out.println(Power(n,x));

    }
}
