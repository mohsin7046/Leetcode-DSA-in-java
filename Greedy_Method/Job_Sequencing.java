package Greedy_Method;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Job_Sequencing {
    public static void main(String[] args) {
        Integer jobs [][] = {{4,20},{1,10},{1,40},{1,30}};  //(deadline,profit)
        int maxProfit = 0;

        //sorted in basis of profit(descending order)
        Arrays.sort(jobs,Collections.reverseOrder(Comparator.comparingDouble(o -> o[1])));
        //sorted in basis of deadline(ascending order)
        Arrays.sort(jobs,Comparator.comparingDouble(o -> o[0]));

        for (int i = 0; i < jobs.length; i++) {    
                System.out.println(jobs[i][0] +" "+ jobs[i][1]); 
        }

        maxProfit = jobs[0][1];
        int deadline = jobs[0][0];

        for (int i = 1; i < jobs.length; i++) {
            if(jobs[i][0] > deadline){
                maxProfit += jobs[i][1];
            }
        }
        System.out.println(maxProfit);
    }
}
