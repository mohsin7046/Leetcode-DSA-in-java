package Queue_Implementation;
import java.util.*;
public class Queue_inbuilt {

    static class QueueUsingTWOStack{

       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void AddQueue(int data){
            if(s1.isEmpty()){
                s1.push(data);
            }
            else{
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                s1.push(data);
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

        public static int RemoveQueue(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty!!!!");
                return -1;
            }
            return s1.pop();
        }

        public static int peekQueue(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty!!!!");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        // Queue <Integer> q = new LinkedList<>();
        // Queue <Integer> q = new ArrayDeque<>();    //Another way for the queue implementation same as LinkedList
        QueueUsingTWOStack queue = new QueueUsingTWOStack();

        //for queue using two stack
        queue.AddQueue(1);
        queue.AddQueue(2);
        queue.AddQueue(3);
        queue.AddQueue(4);
        queue.RemoveQueue();
        
        while (!queue.isEmpty()) {
            System.out.println(queue.peekQueue());
            queue.RemoveQueue();
        }

        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
}
