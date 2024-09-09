package Backtraking;

public class Permutation_String {

    public static void Permutation(String str,String ans){

        //Base Case
        if(str.length() == 0){
            System.out.println(ans+" ");
            return;
        }

        //Recursion
        for (int j = 0; j < str.length(); j++) {

            String newStr = str.substring(0, j) + str.substring(j+1);   //here we need to remove the char which finish it's choice for that we use Substring

            Permutation(newStr, ans+str.charAt(j));
        } 
       
    }


    public static void main(String[] args) {
        String str="abc";
        String ans ="";

        Permutation(str,ans);
    }
}
