package Queue_Implementation;
import java.util.*;
public class InterleaveQueue {

    public static void Interleave(Queue<Integer> q2){
        Queue<Integer> q1 = new LinkedList<>();
        int size = q2.size();

        for (int i = 0; i < (size/2); i++) {
            int r = q2.remove();
            q1.add(r);
        }
      
         while(!q1.isEmpty()){
            q2.add(q1.remove());
            q2.add(q2.remove());
        }

        while (!q2.isEmpty()) {
            System.out.print(q2.peek()+" ");
            q2.remove();       
         }
    }

    public static void main(String[] args) {
        Queue<Integer> q2 = new LinkedList<>();
        int size = 10;
        for (int i = 1; i <= size; i++) {
            q2.add(i);
        }

        Interleave(q2);     //space O(n) and time O(1)
    }
}
