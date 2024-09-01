/*Pattern
 *****  (1,1)(1,2)(1,3)(1,4)
 *   *  (2,1)          (2,4)
 *   *  (3,1)          (3,4)
 *****  (4,1)(4,2)(4,3)(4,4)
 */


/* 
public class PatternII {

    public static void hollowPattern(int row,int col){

        for(int i =1; i<=row ; i++){
            for(int j=1;j<=col;j++){
                if(i==1 || i == 4){                             //(1,1)(1,2)(1,3)(1,4)
                    System.out.print("*");
                }
                else if(j == 1 || j ==4 ){          // (2,2)(2,3) (3,1)(3,2)    
                    System.out.print("*");
                }
                else{
                    System.out.print(" "); 
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        hollowPattern(4,4);
    }
}
*/

/*pattern-2
   *
  **
 ***
****   
 */


 
//  public class PatternII {

//     public static void inverted(int row){
//         int n = row;
//         for(int i=1; i<=row;i++){
//             for(int j=1;j<=row;j++){
//                 if(n <= j) {
//                     System.out.print("*");
//                 } 
//                 else{
//                     System.out.print(" ");
//                 } // n==4 <j==1(t)
//             }
//             n=n-1;
//             System.out.println("");
//         }
//     }
 
//     public static void main(String[] args) {
//         inverted(7);
//     }
//  }
    

// Pattern-3

// 12345
// 1234
// 123
// 12
// 1

// public class PatternII {

//     public static void number_half(int row){
//         int n=row+1;
//         for(int i=1;i<=row;i++){
//             for(int j=1;j<=row;j++){
                
//                 if(n <=j ){
//                 System.out.print(" "); 
//             }
//             else{
//                 System.out.print(j);
//             }
//             }
//             n=n-1;
//             System.out.println("");
//         }

//     }

//     public static void main(String[] args) {
//         number_half(6);
//     }
// }


// Pattern-4 [0-1 Triangle]

// 1
// 0 1
// 1 0 1
// 0 1 0 1
// 1 0 1 0 1



// public class PatternII {

//     public static void triangle(int row){
        
//      for(int i=1;i<=row;i++){ 
//             for(int j=1;j<=i;j++){
                
//                 if((i+j)%2 == 0){
//                     System.out.print(1);
//                 }
//                 else{
//                     System.out.print(0);
//                 }
                
//             }
            
//             System.out.println("");
//         }
//     }
//     public static void main(String[] args) {
//         triangle(10);
//     }
// }


// Pattern-5
// *         *
// **       **
// ***     ***
// ****   ****
// ***** *****
// ***********

public class PatternII {

    public static void butterfly1(int rows,int cols){
    int n = cols;
    int m=1;
        for(int i=1;i<=rows;i++){                       
            for(int j=1;j<=cols;j++){                     
                                                             
                if(n<=j){
                    System.out.print("*");
                }
                else if(m>=j){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            n=n-1;
            m=m+1;
            System.out.println("");
        }
    }

    //  r=3 c=6
    //   ******
    //   **  **
    //   *    *
    public static void butterfly2(int rows,int cols){
        int n =cols;
        int m=1;
            for(int i=rows;i>=1;i--){          //i=3
                for(int j=cols;j>=1;j--){     //j=5 n=6
                    if(n<=j){                                      // ******
                                                                  //  
                        System.out.print("*");
                    }
                    else if(m>=j){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                n=n-1;
                m=m+1;
                System.out.println("");
            }
        }
    

    public static void main(String[] args) {
        // butterfly1(3,6);
        butterfly2(3,6);
    }
}


