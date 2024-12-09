import java.util.*;

public class Array {

public static String AddingSpace(String s, int spaces[]) {
    String result = "";
    int j = 0;
    
    for (int j2= 0; j2 < s.length(); j2++) {
        if(j2 == spaces[j] && j < spaces.length){
            System.out.println("before"+j);
            j++; 
            result = result + " ";
    
            System.out.println("after"+j);
        }
        result = result + s.charAt(j2);
    }

    return result;
}


public static boolean stringSubsequence(String str1, String str2) {
    int j = 0;
    int i = 0;
    int arr[] = new int [26];  //to make array of 'a' to 'z'
    boolean letter = false;

    while(j < str2.length() && i < str1.length()){
        if(str1.charAt(i) == str2.charAt(j)){
            letter = true;
            i++;
            j++;
        }
        else if((char)(((int)str1.charAt(i)+1)) == str2.charAt(j)){
            letter = true;
            System.out.println((char)(((int)str1.charAt(i)+1)));
            str1 = str1.replace(str1.charAt(i),(char)(((int)str1.charAt(i)+1)));
            
            i++;
            j++;
        }else{
            letter = false;
            i++;
        }
    }
    return letter;
}

    public static void main(String[] args) {
        String s = "LeetcodeHeplsMeLearn";
        // int spaces [] = {8,13,15};
        // System.out.println(AddingSpace(s,spaces));

        String str1 = "zc";
        String str2 = "ad";
        System.out.println(stringSubsequence(str1,str2));

       char c = 'a' +1;
        System.out.println(c);
    }
}



