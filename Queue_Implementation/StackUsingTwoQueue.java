package Queue_Implementation;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    static class Twoqueue{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();


        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void Add(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty!!");
                return -1;
            }
            int top=-1;
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek1(){
            if(isEmpty()){
                System.out.println("queue is empty!!");
                return -1;
            }
            int top=-1;
            if(!q1.isEmpty()){
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }else{
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

    }

    public static void main(String[] args) {
        Twoqueue q = new Twoqueue();
        q.Add(1);
        q.Add(2);
        q.Add(3);
        q.Add(4);
        
        while(!q.isEmpty()) {
            System.out.println(q.peek1());
            q.remove();
        }
    }
}
