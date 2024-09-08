package Backtraking;

public class Find_subset_String {

    public static void Subset(String str,int i,String ans){
        //Base Case
        if(i==str.length()){
            System.out.print(ans+",");
            return;
        }

        Subset(str, i+1, ans+str.charAt(i));
        Subset(str, i+1, ans);   //This is backtracking where we hit at a base case then we find for another solution

    }

    public static void main(String[] args) {
        String str = "abc";
        String ans="";
        Subset(str,0,ans);
    }
}
