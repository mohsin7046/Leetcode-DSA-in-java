public class Peak_Element {
    
  public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int peak_index = 0;

        while (start < end) {
            
            if(nums[start] < nums[end]){
                peak_index = end;
                start++;
            }else{
                peak_index = start;
                end--;
            }
        }
        return peak_index;
    }
    
    public static void main(String[] args) {
        int nums [] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
