public class Binomial {
    public static int factorial(int num){
        int fact =1;
        for(int i=1;i<=num;i++){
            fact = fact * i;
        }
        
        return fact;
     }
    public static void main(String[] args) {
        int n=5;
        int r=2;
        System.out.println(factorial(n) / (factorial(r) * factorial(n-r)));
        
    }
}
