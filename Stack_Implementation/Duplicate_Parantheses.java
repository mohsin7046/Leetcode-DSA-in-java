package Stack_Implementation;

import java.util.Stack;

public class Duplicate_Parantheses {
    public static boolean isDuplicate(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' ) {
                int count = 0;
                while(stack.peek() != '('){
                    stack.pop();  //pop the operand, operation
                    count++; 
                }
                if(count < 1){
                    return true; //duplicate exist
                }else{
                    stack.pop();  //for opening bracket
                }
            }else{
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "((a+b)+(c+d))";   //return false
        String s1 = "((a+b))";     //return true
        System.out.println(isDuplicate(s));
    }
}
