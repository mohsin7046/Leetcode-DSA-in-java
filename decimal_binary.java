

public class decimal_binary {

    public static void bin_dec(int num){
        int lastDigit = 0;
        int decimal = 0;
        int i = 0;
         
        while(num > 0){
            lastDigit = num % 10;
            decimal = decimal + (lastDigit * (int)(Math.pow(2,i) ));
            i++;
            num = num/10;
        }

        System.out.println("THe decimal value is :"+decimal);
    }


    public static void dec_bin(int num){
        
        // int n = num;
        int i = 0;
        int binary = 0;

        while(num > 0){
           int rem = num % 2;
           binary = binary + (rem * (int)(Math.pow(10,i)));
           i++;
           num = num/2;
        }
        System.out.println("Binary number is:"+binary);
    }

    public static void main(String[] args) {
        // bin_dec(1001);
        dec_bin(4);
    }
}
