package Backtraking;

public class NQueens_onesolution {
    public static boolean NQueens(char board [][] ,int row){
        //Base case 
        if(row == board.length){
            // count++;       In case if total count is required
            return true;
        }

        for (int j = 0; j < board.length; j++) {

            if(isSafePosition(board,row,j)){
            board[row][j] = 'Q';

           if( NQueens(board, row+1)){
            return true;
           } else{
            board[row][j] = 'x';
           } 
            }  
        }

        return false;

    }

    public static boolean isSafePosition(char board [][] ,int row,int col ){
        //vertical up  (i-1,j)
        for (int i = row-1; i >=0; i--) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left up  (i-1,j-1)
        for (int k = row-1, k1=col-1; k>=0 && k1>=0; k--,k1--) {
                if(board[k][k1] == 'Q'){
                    return false;  
            }
        }

        //diagonal right up  (i-1,j+1)
        for (int i = row-1,j=col+1; i>=0&&j<board.length; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void PrintBoard(char board [][]){
       
        System.out.println("--------ChessBoard--------");
        
        for (int i = 0; i < board.length; i++) { 
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char board [] [] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

       if(NQueens(board,0)) {
        System.out.println("Solution possible");
        PrintBoard(board);
       }else{
        System.out.println("solution cannot possible");
       }
    //    System.out.println("Total ways of board"+" "+count);
    }
}