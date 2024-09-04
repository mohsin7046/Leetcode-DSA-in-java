package Recursion_func;

public class Tiling_Problem {
    
    public static int TotalWays(int n,int totalWays){
        if(n == 0 || n == 1){
            return 1;
        }
        totalWays = TotalWays(n-1, totalWays) + TotalWays(n-2, totalWays);    //n-1 for vertical title and n-2 for horizontal title

        return totalWays;
    }

    public static void main(String[] args) {
        int n = 4;
        int totalWays = 0;  //for floor  2 x n
        //for title 2 x 1
        System.out.println(TotalWays(n,totalWays));
}
}
