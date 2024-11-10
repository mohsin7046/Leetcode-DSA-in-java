package Queue_Implementation;

public class Basic_Queue {

    static class Queue{
        static int arr[];
        static int rear;
        static int size;

        Queue(int n){
            arr = new int [n];
            rear=-1;
            size=n;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full!");
                return;
            }
            rear= rear+1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!!");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1]; 
            }
            rear = rear-1;
            return front;
        }
    

    public static int peek1(){
        if(isEmpty()) {
        System.out.println("Queue is empty"); 
        return -1;   
        }
        return arr[0];
    }
}

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek1());
            q.remove();   // using array it take O(n) time for removing element
        }
    }
}
