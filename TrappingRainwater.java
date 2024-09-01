public class TrappingRainwater {

    public static void RainWater(int [] height ){
          int [] left_Array  = new int [height.length];
          int [] right_Array = new int [height.length];
          int waterLevel =0,sum=0;
          left_Array [0] = height[0];
          right_Array [height.length-1] = height[height.length-1];

          //for Right side
          
          for( int i = 1 ; i < height.length ;i++){
            int j =i-1;
            if(height[i] < left_Array[j]){
                left_Array[i] = left_Array[j];
            }
            else{
                left_Array[i] = height[i];
            }
          }

          for( int i = height.length-2 ; i >= 0 ;i--){
            int j =i;
            if(height[i] < right_Array[j+1]){
                right_Array[j] = right_Array[j+1];
            }
            else{
                right_Array[j] = height[i];
            }
            
          }
  
        //   for (int i = 0; i < right_Array.length; i++) {
        //     System.out.println(right_Array[i]);
        //   }
          //Find Minimum 
          for (int i = 0; i < right_Array.length; i++) {
            int z = Math.min(left_Array[i], right_Array[i]);
            // System.out.println(z);
            waterLevel = z - height[i];
            sum = sum + waterLevel;
          }
          System.out.println(sum);
    
    }

    public static void main(String[] args) {
        int height [] = {4,2,0,6,3,2,5};
        RainWater(height);
    }
}
