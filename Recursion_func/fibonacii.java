package Recursion_func;

public class fibonacii {

    public static int fib(int n){
        if(n ==1 || n==0){
           
            return n;
        }

          int fib1 = fib(n-1);
          int fib2 = fib(n-2);

         int fib = fib1 + fib2;
         return fib;
        
    }

    public static void main(String[] args) {
        int n = 4;
       System.out.println( fib(n)); 
    }
}

//Space-complexity - O(n)
//Time-Complexity - O(2^n)
