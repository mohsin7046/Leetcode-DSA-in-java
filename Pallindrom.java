public class Pallindrom {

    public static boolean isPalindrome(int n) {

        int temp = n;
        int rev = 0;

        while (n > 0) {

            int rem = n % 10;

            rev = rev * 10 + rem;

            n = n / 10;
        }

        if (temp == rev) {
           return true;
        }
  return false;
    }
    public static void main(String[] args) {
        int x = 144;
      System.out.println(isPalindrome(x));   
    }
}
