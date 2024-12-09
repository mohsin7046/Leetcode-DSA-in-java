package Greedy_Method;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        int values [] = {60,100,120};
        int weight[] = {10,20,30};
        int capacity = 50;
        double totalProfit = 0;

        //For sorting ratio in descending order
        double sortedRatio [][] = new double [values.length][2];
        for (int i = 0; i < sortedRatio.length; i++) {
            sortedRatio[i][0] = values[i]/(double)weight[i];
            sortedRatio[i][1] = i;
        }

        Arrays.sort(sortedRatio,Comparator.comparingDouble(o -> o[1]));  //sort according to ratio in ascending order therefore loop start from back

        for (int i = 0; i < sortedRatio.length; i++) {
            System.out.print(sortedRatio[i][0]);
        }

        //knapsack
        for (int j = 0 ; j < sortedRatio.length ; j++) {
            int idx = (int)sortedRatio[j][1];
            
            if(weight[idx] <= capacity){
                System.out.println(capacity);

                totalProfit = totalProfit + values[idx];
                capacity = capacity - weight[idx];

                System.out.println(capacity);
                System.out.println(totalProfit);
            }else {
                totalProfit = totalProfit + ((sortedRatio[j][0]) * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final value:  "+ totalProfit);
        // System.out.println(capacity);

    }
}
