package Recursion_func;

public class Remove_Duplicate_String {

    public static void Duplicate(String str,int i,StringBuilder newstr, boolean map []){
        if(i == str.length()){
            System.out.println(newstr);
            return;
        }

        char currentChar = str.charAt(i);

        if(map[currentChar-'a'] == true){
            Duplicate(str, i+1, newstr, map);
        }else{
            map[currentChar-'a'] = true;
            Duplicate(str, i+1, newstr.append(currentChar), map);
        }

    }

    public static void main(String[] args) {
        String str = "appnnacollege";
        int i=0;
        StringBuilder newstr = new StringBuilder("");
        boolean map [] = new boolean [26];

       Duplicate(str,i,newstr,map); 
    }
}
