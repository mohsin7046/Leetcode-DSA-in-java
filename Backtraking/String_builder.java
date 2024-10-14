package Backtraking;

public class String_builder {
    

    public static void main(String[] args) {
        String Random [] = {"a","b","c"};
       StringBuilder sb = new StringBuilder();
       String Random1 []= {"d","e","f"};

       for (int i = 0; i < Random.length; i++) {
        sb.append(Random[i]);
       }
       for (int index = 0; index < Random1.length; index++) {
        sb.append(Random1[index]);
       }
       System.out.println(sb.toString());
       
    }
}
