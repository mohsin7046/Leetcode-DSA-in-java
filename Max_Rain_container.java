public class Max_Rain_container {
  
        public static int maxArea(int[] height) {
            int water_max = 0;
            int right =height.length-1;
            int left = 0;
            
            while(left<right){
             int min = Math.min(height[left],height[right]);
                water_max = Math.max(water_max,min*(right-left));

                if(height[left] < height[right]){
                ++left;
                }
                
                else{
                    --right;
                }
            }

            return water_max;
        }
    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6}; 
       System.out.println(maxArea(height));
    }
}
