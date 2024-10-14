package ArrayList;

import java.util.ArrayList;

public class Rotated_Pair2_sum {

public static boolean Pair2(ArrayList <Integer> numbers,int target){

    int bp = -1;
    int n = numbers.size();

    for (int i = 0; i < n; i++) {
        if(numbers.get(i) > numbers.get(i+1)){
            bp=i;      //It points to 11 
            break;
        }
    }
    
    int left = bp+1; //points at smallest      //It point to 6
    int right = bp;  //points at largest

    while (right != left) {
        if(numbers.get(left) + numbers.get(right) == target){
            return true;
        }

        if(numbers.get(left) + numbers.get(right) < target){     
            left = (left+1)%n;         //for rotation
        }else{
            right = (n+right-1)%n;    // for rotation 
        }
    }

    return false;
}
    
    public static void main(String[] args) {
        ArrayList <Integer> numbers = new ArrayList<>();
        //placed element in Rotated 

        numbers.add(11);
        numbers.add(12);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        int target = 16;

        System.out.println(Pair2(numbers,target));    //Using 2 pointer Approach
    }
}
