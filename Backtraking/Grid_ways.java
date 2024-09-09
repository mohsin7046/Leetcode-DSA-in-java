package Backtraking;

public class Grid_ways {

    public static int Grid(int n,int m,int x,int y){
        //Base case
        if(x == n-1 && y == m-1){
            return 1;
        }else if(x==n|| y==n){
            return 0;
        }

        //Recursion
        int totalWays = Grid(n,m, x+1, y) + Grid(n,m, x, y+1);
        return totalWays;
        
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        System.out.println(Grid(n,m,0,0));
    }
}
