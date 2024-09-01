public class ConcatinationOfArray {
    
    public static int [] Conncate(int arr []){

        int n = arr.length;
        int nums [] = new int [2*n];

        for(int i = 0;i<nums.length;i++){

            if(i<n){
                nums[i] = arr[i];
            }else{
                nums[i] = arr[i-n];
            }
        }

        return nums;
       
    }

    public static void main(String[] args) {

        int arr [] = {1,2,3,4,5,6};
        int result [] = Conncate(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]); 
        }
       
    }
}
