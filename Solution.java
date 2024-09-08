




// class Solution {
//     public static int mySqrt(int x) {
//         return (int) Math.floor(Math.sqrt(x));
//     }
//     public static void main(String[] args) {
//         int x = 7;
//         System.out.println(mySqrt(x));
//     }
// }





// class Solution {
    
//     public static int maxSubArray(int[] nums) {
//      int maxsum = Integer.MIN_VALUE;
//      int currentsum = 0;

//      for(int i =0;i<nums.length;i++){
//         if(maxsum < 0 && nums[i] < 0){
//             maxsum = Math.max(nums[i],maxsum);
//         }else{
//          currentsum = currentsum + nums[i];
//          if(currentsum < 0){
//              currentsum = 0;
//          }
//         //  System.out.println(currentsum);
//          maxsum = Math.max(maxsum,currentsum);
//         }
//      }
//      return maxsum;
//  }

//  public static void main(String[] args) {
//      int arr [] = {-1};

//     System.out.println(maxSubArray(arr)); 
//  } 
 
// }





// class Solution {
//     public static boolean threeConsecutiveOdds(int[] arr) {
//         int count=0;
//         for (int i=0;i<arr.length ;i++ ){
//             if (arr[i]%2!=0){
//                 count++;
//                 if(count==3){
//                     return true;
//                 }
//             }else{
//                 count =0;
//             } 
            
//         } 
//         return false;
//     }
// }




// class Solution {
//     public static int removeElement(int[] nums, int val) {
//         int count = 0;
//         for(int i=0;i<nums.length-1;++i){
//             if(val == nums[i] ){
//                 int temp = nums[i+1];
//                 nums[i+1] = '_';
//                 nums[i] = temp;
//                 count ++;
//             }
//             else{

//                 int temp = nums[i+1];
//                 nums[i+1] = '_';
//                 nums[i] = temp;
                
//             }
//         }
//         for (int i = 0; i < nums.length; i++) {
//             System.out.println(nums[i]);
//         }
//         return count;
//     }
//     public static void main(String[] args) {
//         int nums [] = {2,3,2,2};
//         int val = 3;
//         System.out.println(removeElement(nums,val));
//     }
// }



// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int[] temp = new int[2*n];

//         for(int i=0; i<n; i++){
//             temp[2 * i] = nums[i];         
//             temp[2 * i + 1] = nums[i + n]; 
//         }
//         return temp;
//     }
// }



class Solution {
    public static boolean isUgly(int n) {
        if(n ==1) return true;

        if(((n % 2 == 0 || n % 3==0) && n%5==0) || (n % 2 == 0 && (n % 3==0 || n%5==0)) || (n % 3 == 0 && (n % 2==0 || n%5==0)) || (n % 2 == 0 && n % 3==0 && n%5==0) || (n % 2 == 0 || n % 3==0 || n%5==0)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(isUgly(n));
    }
}