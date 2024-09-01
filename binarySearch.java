public class binarySearch {

    public static int search(int arr[] , int key){
     
        int start =0,end=arr.length - 1;

        while (start <= end) {
            int mid = (start + end)/2;

            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){   //right
                start = mid +1;
            }
            else {   //left
                end = mid -1;
            }
        }

    return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int key = 9;

        System.out.println(search(arr, key));
    }
}

/*
  1 2 3 4 5 6 7 8 9    key =9         => s =0,end =8
  1 2 3 4 5 6 7 8 9            => mid = 4      arr[mid] (4) != key(9)
  1 2 3 4 5 6 7 8 9  arr[mid] (4) < key(9)  //start = mid +1    s = 4
  1 2 3 4 5 6 7 8 9  arr[mid] (7) < key(9)  ==> mid = 4 + 8 /2 = 6  ==> start = mid +1
 */