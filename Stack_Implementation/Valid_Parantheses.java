package Stack_Implementation;

import java.util.Stack;

public class Valid_Parantheses {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            
           else if ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '[') ) {
                stack.pop();
            }
            else{
                return false;
            }

            if(!stack.isEmpty() && i == s.length()-1){
                return false;
            }
             
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(({[]}())";
        System.out.println(isValid(s));
    }
}
