package Greedy_Method;

public class Jump {

    public static boolean jump(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if(i > max) return false;
                if (i + nums[i] > max) {
                    max = Math.max(max,i + nums[i]);
                }
            }
            return max >= n - 1;
    }

    public static int jump2(int[] nums) {
        int n = nums.length;
        int max = 0;
        int jumps = 0;
        int end = 0;
        
        for (int i = 0; i < n - 1; i++) {
                    max = Math.max(max,i + nums[i]);
                    if(i == end){
                        jumps++;
                        end = max;
                    }
                }
                return jumps;
            }   
            

    public static void main(String[] args) {
        int [] matrix = {3,2,1,0,4};
        System.out.println(jump(matrix));
        System.out.println(jump2(matrix));
    }
}
