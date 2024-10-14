package Backtraking;

import java.util.ArrayList;

public class Rat_in_maze {

    public static ArrayList <String> Grid(int maze [][],int n){

        int [][] visited = new int [n][n];    // for knowing that the row and column is visited or not for backtracking

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                visited[i][j] = 0;
            }
        }

        ArrayList <String> list = new ArrayList<>();

        if(maze[0][0] == 0) {       // when source become zero 
            list.add("-1");
            return list;
        }

        if(maze[n-1][n-1] == 1)   //For last value is one then it is safe
            isSafe(list, "", n,maze, 0, 0, visited);
       
         return list;
    }

    public static void isSafe( ArrayList <String> list,String inner,int n,int maze[][], int row,int col,int[][]visited){

        if(row == n-1 && col == n-1){
            list.add(inner);
            return;
        }

        
        //for up
        
        if(row-1 >= 0 && visited[row-1][col] == 0 && maze[row-1][col] == 1 ){
            visited[row][col] = 1;
            isSafe(list, inner+'U', n, maze, row-1, col, visited);
            visited[row][col] = 0;    //when we backtrack then we have unvisited the row and column
        }
    
        //for down
        if(row+1 < n && visited[row+1][col] == 0 && maze[row+1][col] == 1 ){
            visited[row][col] = 1;
            isSafe(list, inner+"D", n, maze, row+1, col, visited);
            visited[row][col] = 0;    //when we backtrack then we have unvisited the row and column
        }


        //for left
        if(col-1 >= 0 && visited[row][col-1] == 0 && maze[row][col-1] == 1 ){
            visited[row][col] = 1;
            isSafe(list, inner+'L', n, maze, row, col-1, visited);
            visited[row][col] = 0;    //when we backtrack then we have unvisited the row and column
        }


        //for right
        if(col+1 < n && visited[row][col+1] == 0 && maze[row][col+1] == 1 ){
            visited[row][col] = 1;
            isSafe(list, inner+"R", n, maze, row, col+1, visited);
            visited[row][col] = 0;    //when we backtrack then we have unvisited the row and column
        }

    }

    public static void main(String[] args) {
    
        int maze[][] = { { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 0, 0 },
                        { 1, 1, 1, 1 } };
  
    System.out.println(Grid(maze,4)); 
        // System.out.println(maze[1][1]);
        
    }

}
