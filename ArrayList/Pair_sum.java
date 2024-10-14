package ArrayList;

import java.util.ArrayList;

public class Pair_sum {

    public static boolean BT_Pairing(ArrayList <Integer> numbers,int target){
        

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                if(numbers.get(i) + numbers.get(j) == target)  {
                    return true;
                }
            }     
        }

        return false;
    }


    //Using Two Pointer Approach - O(n)
    public static boolean Tw_Pt_Pairing(ArrayList <Integer> numbers,int target){
        int i = 0;
        int j = numbers.size()-1;

        while(i<j){

                if(numbers.get(i) + numbers.get(j) == target){
                    return true;
                }
                else if(numbers.get(i) + numbers.get(j) < target){     // this condition statisfy if arraylist element placed in sorted way
                    i++;
                }else{
                    j--;
                }
                
            }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList <Integer> numbers = new ArrayList<>();
        //placed element in Sorted 
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        System.out.println("Using Brute Force Approach : "+BT_Pairing(numbers,5));    //Using Brute-Force Approach
        System.out.println("Using Two Pointer Approach : "+Tw_Pt_Pairing(numbers,5));        //Using Two pointer Approach

    }
}
