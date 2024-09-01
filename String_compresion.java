public class String_compresion {

    public static String compresion(String s){

        String newstring = "";
        
        
        for(int i = 0;i<s.length();i++){
            Integer count =1;
           
            while(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            newstring+=s.charAt(i);
            if(count > 1){
                newstring+=count.toString();
            }
        }
return newstring;
        
    }

    public static void main(String[] args) {
        String s = "aaabbbbbbcc";
      System.out.println(compresion( s)); 
    }
}
