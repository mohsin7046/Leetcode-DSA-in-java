
public class ToUppercase {


    public static String toupper(String s) {
    StringBuilder sb = new StringBuilder("");

    char ch = Character.toUpperCase((s.charAt(0)));
     sb.append(ch);

    for (int i = 1; i < s.length(); i++) {
        if(s.charAt(i) == ' '){
            char ch1 = Character.toUpperCase((s.charAt(i+1)));
            sb.append(ch1);
            i++;
        }else{
            sb.append(s.charAt(i));
        }
    }
    return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello world ali";
       System.out.println(toupper(s)); 
    }
}
