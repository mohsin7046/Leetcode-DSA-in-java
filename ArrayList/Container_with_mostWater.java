package ArrayList;

import java.util.*;

public class Container_with_mostWater {

    //Brute Force Approach 
    public static int BT_store_Water(ArrayList <Integer> container){    
        int max_water = 0;

        for (int i = 0; i < container.size(); i++) {
            for (int j = i+1; j < container.size(); j++) {
                int height = Math.min(container.get(i), container.get(j));
                int width = j-i;
                int currentWater = height * width;

                max_water = Math.max(max_water, currentWater);
            }
        }
        return max_water;
    }

    //Two pointer Approach
    public static int TwPt_store_Water(ArrayList <Integer> container){
        int max_water = 0;
        int i=0;
        int j = container.size()-1;

        while(i<j){
            if(container.get(i) < container.get(j)){
                max_water = Math.max(max_water, container.get(i)*(j-i));
                i++;
            }else{
                max_water = Math.max(max_water, container.get(j)*(j-i));
                j--;
            }
        }

        return max_water;
    }

    public static void main(String[] args) {
        ArrayList <Integer> container =new  ArrayList<>();
        container.add(1);
        container.add(8);
        container.add(6);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(8);
        container.add(3);
        container.add(7);

        //Brute Force Approach
       System.out.println("From Brute Force Approach in O(n^2): " + BT_store_Water(container)); // O(n^2)
       System.out.println("From Two pointer Approach in O(n): "+TwPt_store_Water(container));  //Two pointer Approach  O(n)
    }
}
