import java.util.Arrays;
import java.io.*;
import java.util.*;
public class Rotate_Image {

   public static void rotate(int[][] matrix) {
           int top = 0,bottom=matrix.length-1;
           
           while(top < bottom){
            for (int j2 = 0; j2 < matrix.length; j2++) {
                int temp = matrix[top][j2];
                matrix[top][j2] = matrix[bottom][j2];
                matrix[bottom][j2]= temp;
            }
            top++;        
            bottom--;
     }

    for (int i = 0; i < matrix.length; i++) {
        for (int j = i+1; j < matrix.length; j++) {
           int temp =  matrix[j][i];  //temp =4
           matrix[j][i] = matrix[i][j];  // = 8
           matrix[i][j] = temp;  // = 4
        }
        
    }
}

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
           System.out.println("");
        }
    }
}