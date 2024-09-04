package Recursion_func;

public class Decode_String {

    public static void decode(String s,int i,String newStr,int loop){
          if(i == s.length()){
              return;
          }
          
          System.out.println(loop);

          if(loop <= 0 && s.charAt(i) == '['){
            newStr = newStr + s.charAt(i+1);
          }

          
              decode(s,i+1,newStr,s.charAt(i-1));
          

    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        int i =0;
        int loop = 0;
        String newstr = "";
        decode(s,i,newstr,loop);
    }
}
