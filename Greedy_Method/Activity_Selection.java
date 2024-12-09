package Greedy_Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};  //Sorted 

        //If Sorted not given 
        int activity[][] = new int [start.length][3];
        for (int i = 0; i < activity.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        //using lambda function
        Arrays.sort(activity,Comparator.comparingDouble(o -> o[2]));  //sorted according to end time
   for (int j = 0; j < activity.length; j++) {
    System.out.println(activity[j][0]+" "+activity[j][1]+" "+activity[j][2]);
   }
        int maxActivity=0;
        ArrayList <Integer> list = new ArrayList<>();
        int last_chosen= 0;

        //First activity always selected
        maxActivity=1;
        list.add(0);   //list.add(activity[0][0])
       last_chosen=0;  

       for (int i = 0; i < end.length; i++) {
            if(start[i] >= end[last_chosen]){
                maxActivity++;
                list.add(i);
                last_chosen=i;
            }
       }
 

       
       System.out.println(maxActivity);
       for (int i = 0; i < list.size(); i++) {
        System.out.print("A"+list.get(i)+" ");
       }

    }
}
