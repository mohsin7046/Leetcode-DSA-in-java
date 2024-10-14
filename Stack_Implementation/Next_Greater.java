package Stack_Implementation;
import java.util.Stack;

public class Next_Greater {

    public static void Greater(int arr[],int next_greater[],Stack <Integer> s){
        for (int i = arr.length-1; i >= 0; i--) {
            next_greater[i] = -1;
            while(!s.isEmpty()){
               if (s.peek() <= arr[i])
                 s.pop();
                else {
                 next_greater[i] = s.peek();  
                 break;
                }
            }
            s.push(arr[i]);  
        }
    }

    public static void main(String[] args) {

        int arr[] = {6,8,0,1,3};
        int next_greater [] = new int[arr.length];
        Stack <Integer> s = new Stack<>();

        Greater(arr,next_greater,s);

        for (int i = 0; i < next_greater.length; i++) {
            System.out.println(next_greater[i]);
        }
    }
}
