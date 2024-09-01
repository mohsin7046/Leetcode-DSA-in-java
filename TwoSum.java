// public class tw0_sum {
//     static int j;
//     static boolean a =true;
//     public static int[] func(int arr [],int target){
//         int[] result;
//         for(i=0;i<arr.length;i++){
//             for(j=0;j<arr.length;j++){
//                 if (target == arr[i]+arr[j+1]) {
//                     a= false;
//                     // store here that return array index
//                      result []= {i,j+1};
//                     break;
//                 }
                
//             }
//             if (a==false) {
//                     break;
//             }
//         }
//         // return above resuilt ARRAY

//     }
//     public static void main(String[] args) {
//         int arr [] = {1,2,3,4,5};
//         int target = 5;
//         func(arr,target);
//     }
// }

// give me the program for twosum using function and return array indexes
// and also tell me how to return array in java function
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,1,4 };
        int target = 5;
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}