public class Minimal_Operation {
    
        public static int minimumOperations(int[] nums) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] % 3 != 0){
                    count ++;
                }
            }

            return count;
        }
    

        public static void main(String[] args) {

                int arr [] = {3,6,9,1};

            System.out.println(minimumOperations(arr));
        }
}
