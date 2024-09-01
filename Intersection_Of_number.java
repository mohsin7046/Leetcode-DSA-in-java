class Intersection_Of_number {
    public static int [] intersect(int[] nums1, int[] nums2) {
        int j=0;
        int i=0;
        int [] arr = {};
        if(nums1.length >= nums2.length){
            
            for( i=0;i<nums2.length;++i){
                for(j=0; i<nums1.length;++j){
                if( nums1[j] == nums2[i]){
                    arr = new int [] {nums1[j]};    
                    break;
                }
            }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.println(arr[k]);
            }
           
        }
        return arr;
    }

    public static void main(String[] args) {
        int nums1 [] = {1,2,2,1};
        int nums2 [] = {2,2};
        int[] result = intersect(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println( result[i]);
        }
       
    }
}