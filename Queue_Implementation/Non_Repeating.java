package Queue_Implementation;
import java.util.*;

public class Non_Repeating {

    public static void nonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq [] = new int[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty()){
                if(freq[q.peek()-'a']>1){
                    q.remove();
                }else{
                    System.out.println(q.peek() + " ");
                    break;
                }
            }

            if(q.isEmpty()){
                System.out.println(-1 + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        nonRepeating(str);
    }
}
