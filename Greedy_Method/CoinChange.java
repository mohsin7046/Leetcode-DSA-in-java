package Greedy_Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CoinChange {
    public static void main(String[] args) {
        Integer coins [] = {1,2,5,10,20,50,100,500,2000};
        int n = 590;
        int ans = 0;
        ArrayList <Integer> list = new ArrayList<>();
    
        Arrays.sort(coins,Collections.reverseOrder());
        // System.out.println(coins[0]);
        int  i = 0;
  //2000,500,100,50,20,10,5,2,1

     while(i < coins.length){
        if(n != 0){
        if(coins[i] <= n){
            n = n - coins[i];
            list.add(coins[i]);
            ans++;
        }else{
            i++;
        }
    }else{
        break;
    }
     }

     System.out.println(ans);

     for (int j = 0; j < list.size(); j++) {
        System.out.print(list.get(j)+" ");
     }
    }
}
