public class longestCommonPrefix {
     
            public static String longestCommonPrefix(String arr []){
            
                if (arr.length == 0)
                return "";
          
              for (int i = 0; i < arr[0].length(); ++i){
                for (int j = 1; j < arr.length; ++j){
                  if (i == arr[j].length() || arr[j].charAt(i) != arr[0].charAt(i)){
                    return arr[0].substring(0, i);}
            
                }
              }
              return arr[0];
            }
            
            public static void main(String[] args) {
                String arr [] = {"flour","flower","floor"};
        
               System.out.println(longestCommonPrefix(arr));
            }
        
}
