package Divide_and_Conquer;

public class Merge_Sort {

    public static void PrintArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

public static void Merge_sort(int arr[] ,int si, int ei){

    if(si>=ei){
        return;
    }

    int mid = si+(ei-si)/2;
    Merge_sort(arr, si, mid);
    Merge_sort(arr, mid+1, ei);
    Merge(arr,si,mid,ei);
}

public static void Merge(int arr [],int si,int mid ,int ei){

    int temp[] = new int [ei-si+1];

    int i=si;   //For left side array
    int j = mid+1; //for Right side Array
    int k =0; //For Temp Array

    while(i<=mid && j <=ei){
    if(arr[i] < arr[j]){
        temp[k] = arr[i];
        i++;
        k++;
    }else{
        temp[k] = arr[j];
        j++;
        k++;
    }
}

        while (i<=mid) {       //For left
            temp[k++] = arr[i++];
        }

        while(j<=ei){
            temp[k++] = arr[j++];
        }

        //For copying the temp array to the original array

        for ( k = 0,i=si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
            
        }

}


    public static void main(String[] args) {
        int arr [] = {7,8,5,1,9,4,5};
        int si =0;
        int ei = arr.length -1;

        Merge_sort(arr,si,ei);
        PrintArr(arr);
    }
}
