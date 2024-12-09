package Greedy_Method;

import java.util.Arrays;
import java.util.Collections;

public class Chocola_Problem {
    public static void main(String[] args) {
        int n = 4,m=6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHori[] = {4,1,2};

        //sort both in descending order
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHori,Collections.reverseOrder());

        int h=0,v=0; //for arrays
        int hp=1,vp=1; //horizontal and vertical piece
        int minCost = 0;

        while(h < costHori.length && v < costVer.length){
            if(costHori[h] >= costVer[v]){
                
                minCost+=(costHori[h]*vp);
                hp++;
                h++;
            }else{
               
                minCost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h < costHori.length){
            minCost+=(costHori[h]*vp);
            hp++;
            h++;
        }

        while(v < costVer.length){
            minCost+=(costVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println("Minimun cost :"+minCost);
    }
}
