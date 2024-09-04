package Recursion_func;

public class Friends_pairing {

    public static int Friends(int n){
        if(n == 2 || n == 1){
            return n;
        }
        int pair_single = Friends(n-1) + (n-1)*Friends(n-2);
        return pair_single;
    }

    public static void main(String[] args) {
        int n =3;
        System.out.println(Friends(n));
    }
}
