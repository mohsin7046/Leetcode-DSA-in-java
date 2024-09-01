public class Subarray {
   
        public static void SubArray(int arr []){
            int max_sum =Integer.MIN_VALUE;
             
            for(int i=0;i<arr.length;i++){
                 int start = i;
                
                for(int j=i;j<arr.length;j++){
                    int end = j;
                    int sum =0;
    
                    for(int k=start; k<=end ; k++){
                        // System.out.print(arr[k]);
                        sum = sum + arr[k];
                        if(sum > max_sum){
                            max_sum = sum;                         
                        }
                    }
                    
                    // System.out.println("");
                       System.out.println("  "+sum);
                }
                // System.out.println("");
            }
    
            System.out.println("Larger sum is"+max_sum);
        }
        
        public static void main(String[] args) {
            int arr [] = {1,3,5,7,60};
    
            SubArray(arr);
        }
    
}
