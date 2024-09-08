package Recursion_func;

public class Friends_pairing {

    public static int Friends(int n){
        if(n == 2 || n == 1){
            return n;
        }
        int pair_single = Friends(n-1) + (n-1)*Friends(n-2);   // the first Friend(n-1) is for single person and 
        // Friend(n-2) is for pair but in pair single person also have chance multiply by (n-1)
        return pair_single;
    }

    public static void main(String[] args) {
        int n =3;
        System.out.println(Friends(n));
    }
}
