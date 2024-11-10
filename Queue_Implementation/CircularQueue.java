package Queue_Implementation;

import Queue_Implementation.CircularQueue.CirQueue;

public class CircularQueue {
    static class CirQueue{
        static int arr[];
        static int rear;
        static int size;
        static int front;

        CirQueue(int n){
            arr = new int [n];
            rear=-1;
            front=-1;
            size=n;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }


        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full!");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear= (rear+1)%size;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!!");
                return -1;
            }

            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
            return result;
        }
    

    public static int peek1(){
        if(isEmpty()) {
        System.out.println("Queue is empty"); 
        return -1;   
        }
        return arr[front];
    }
}

    public static void main(String[] args) {
        CirQueue q = new CirQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.add(6);

        while (!q.isEmpty()) {
            System.out.println(q.peek1());
            q.remove();   // using array it take O(n) time for removing element
        }
    }
}
