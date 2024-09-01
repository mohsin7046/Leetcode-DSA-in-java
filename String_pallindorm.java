public class String_pallindorm {


public static boolean isPallindrome(String s){
    int start = 0;
    int end = 0;
    boolean result=false;

    for(int i = 0; i < (s.length())/2; i++){

        if(s.charAt(i) != s.charAt(s.length() - i - 1)){
            result = false;
        }else{
            result = true;
        }
    }

    return result;
}

    public static void main(String[] args) {
        String str = "abcd";

        System.out.println(isPallindrome(str));
    }
}
