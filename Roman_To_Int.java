public class Roman_To_Int {

            public static int romanToInt(String s) {
              int sum = 0;
             char [] roman = new char[128];
          
              roman['I'] = 1;
              roman['V'] = 5;
              roman['X'] = 10;
              roman['L'] = 50;
              roman['C'] = 100;
              roman['D'] = 500;
              roman['M'] = 1000;
        
              for(int i=0;i<s.length()-1;++i){
              if(roman[s.charAt(i)] < roman[s.charAt(i+1)]){
                sum -= roman[s.charAt(i)];
              }
              else{
                sum += roman[s.charAt(i)];
              }
            } 
        
             sum = sum + roman[s.charAt(s.length()-1)];
               return sum;
            }
        
             public static void main(String[] args) {
                 String s = "IV";
                System.out.println(romanToInt(s)); 
             }
          
}
