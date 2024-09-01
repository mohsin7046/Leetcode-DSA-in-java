

public class Kadans {

    public static int alternatingSubarray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int currentsum = 0;
        
        for(int i =0;i<nums.length;i++){
            currentsum = currentsum + nums[i];
           
            if(currentsum < 0){
                currentsum = 0;
            }
            maxsum = Math.max(maxsum,currentsum);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int nums [] = {1,-1,2,4};
        
       System.out.println(alternatingSubarray(nums));
    }
}
