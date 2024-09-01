public class First_last_position {
    public static int[] searchRange(int[] nums, int target) {
        
            int start =0;
            int ans [] = new int [nums.length];
            int end = nums.length-1;
            int mid = 0;
            int i =0;

         if(nums.length == 0) {
            return new int [] {-1,-1};
        }

            while(start<=end) {
     
              mid = start + (int) Math.floor((end - start)/2);      
     
             if(nums[mid]==target){        //mid = 2
                 ans[i] = mid;
                 i=1;
                
             }else if(nums[mid]>target){
     
                 end = mid - 1;
             }
             else{
                 start = mid + 1;    //start = 3
             }
     
            } 

            if(nums[mid] != target){
                return new int [] {-1,-1};
            }

            return new int[] {ans[0],ans[1]};
    }

    public static void main(String[] args) {
        int[] nums = {1,5,5,8,8,9,9};
        int target = 8;
        
        int[] result = searchRange(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
