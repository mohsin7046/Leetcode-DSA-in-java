package Divide_and_Conquer;

public class Search_Rotate_array {

    public static int Search(int arr [],int tar,int si,int ei){
        int mid = si+(ei-si)/2;

        if(arr[mid] == tar){
            return mid;
        }

        //Case-1 if mid lies in Line-1(L-1)
        if(arr[si]<=arr[mid]){
            //case-a  for left
            if(arr[si] <=tar && tar <= arr[mid]){
                return Search(arr, tar, si, mid-1);
            }
            //case-b for right
            else{
                return Search(arr, tar, mid+1, ei);
            }
        }

        //Case -2 if mid lies in Line-2(L-2)
        else{
            //case-c for right
            if(arr[mid] <= tar && tar <= arr[ei]){
                return Search(arr, tar, mid+1, ei);
            }
            //case-d for left
            else{
                return Search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr [] = {5,6,7,0,1,2,3,4};
        int targetindex = Search(arr,3,0,arr.length-1);
        System.out.print(targetindex);
    }
}
