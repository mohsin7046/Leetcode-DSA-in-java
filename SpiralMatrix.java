
public class SpiralMatrix {

    public static void spiralPrint(int matrix [][]){

        if(matrix == null || matrix.length == 0){
            return;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n-1;    
        int left = m-1;
        int right = 0;

    
        while(top <= bottom && right <= left)
{            //For Top
            for(int i = right ; i <= left; i++){
                System.out.print(matrix[top][i] + " ");
            }
            //For Right
            for(int j = top+1 ; j <= bottom ; j++){
                System.out.print(matrix[j][left] + " ");
            }
            //For bottom
            for(int k = left-1  ; k >= right ; k--){
                if(right == left){
                    return;
                }
                System.out.print(matrix[bottom][k] + " ");
            }
            //For Left
            for(int i = bottom-1 ; i >= top+1 ; i--){
                if(right == left){
                    return;
                }
                System.out.print(matrix[i][right] + " ");
            }

            right++;
            top++;
            left--;
            bottom--;
            
           
                
        }

    }

    public static void main(String[] args) {
        int matrix [][] = {{1,2,3,4 ,5},
                           {6,7,8,9,10},
                           {11,12,13,14,15},
                           {16,17,18,19,20},
                           {21,22,23,24,25 }};

        spiralPrint(matrix);
    }
}
