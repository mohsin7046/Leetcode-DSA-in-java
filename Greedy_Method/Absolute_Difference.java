package Greedy_Method;

import java.util.Arrays;

public class Absolute_Difference {
    public static void main(String[] args) {
        int arr1 [] = {4,1,8,7};
        int arr2 [] = {2,3,6,5};
        int minSum = 0;

        //Sort the two array
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr2.length; i++) {
            minSum = minSum + Math.abs(arr1[i]-arr2[i]);
        }

        System.out.println(minSum);
    }
}
