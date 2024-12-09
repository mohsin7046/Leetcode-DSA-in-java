package Greedy_Method;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLength_Chain {
    public static void main(String[] args) {
        int pairs [][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        int maxLen = 0;

        //sort bases of 2nd elements
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

       for (int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i][0] + " " + pairs[i][1]) ;
        
       }

        maxLen = 1; //Select the first pair
        int last_selected = pairs[0][1];
        

        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] >= last_selected){
                maxLen++;
                last_selected = pairs[i][1];
            }
        }
        System.out.println(maxLen);

    }
}
