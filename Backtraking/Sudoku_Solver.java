package Backtraking;

public class Sudoku_Solver {

    public static boolean Solver(int sudoku [][],int row,int col){
        //Base Case
        if(row == 9 && col == 0){
            return true;
        }

        int nextRow = row,nextCol = col+1;
        if(nextCol  == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        //Recursion
        if(sudoku[row][col] != 0){        //this condition is for the value which is inbuilt in array(We cannot change them)
            return Solver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku,row,col,digit)){ 
                sudoku[row][col] = digit;
               if (Solver(sudoku, nextRow,nextCol)){
                return true;
               }
               sudoku[row][col] = 0;
            }
            
        }
        return false;
    }

    public static boolean isSafe(int sudoku [][],int row,int col,int digit){
        //horizontal
        for (int i = 0; i <=8; i++) {
            if(sudoku[row][i] == digit){
                return false;
            }
        }
        //vertical
        for (int i = 0; i <=8; i++) {
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //grid
        int sr = (row/3) * 3;  //for gird(3x3) starting row
        int sc = (col/3) * 3;  //for gird(3x3) starting column

        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static void PrintSudoku(int sudoku [][]){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku [] [] = {{0,0,8,0,0,0,0,0,0},
                     {4,9,0,1,5,7,0,0,2},
                    {0,0,3,0,0,4,1,9,0},
                    {1,8,5,0,6,0,0,2,0},
                    {0,0,0,0,2,0,0,6,0},
                    {9,6,0,4,0,5,3,0,0},
                    {0,3,0,0,7,2,0,0,4},
                    {0,4,9,0,3,0,0,5,7},
                    {8,2,7,0,0,9,0,1,3}
    };

   if(Solver(sudoku,0,0)) {
    System.out.println("Solution exist");
    PrintSudoku(sudoku);
   }else{
    System.out.println("Solution not exist");
   }
    
}
}
