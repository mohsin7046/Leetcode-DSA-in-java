public class DifferceOfSum {
    public static int differenceOfSums(int n, int m) {
        int evenresult = 0;
        int oddresult = 0;
        for (int i = 1; i <= n; i++) {
            if(i%m == 0){
                evenresult += i;
            }else{
                oddresult += i;
            }
        }
      

        return oddresult - evenresult;
    }

    public static void main(String[] args) {
       int n = 10, m = 3;

       System.out.println(differenceOfSums(n, m));
    }
}
