package LinkedList;
import java.util.*;

public class LinkedList_Example {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

 //Delete N Nodes After M Nodes of a Linked List
    public void DNM(int n, int m) {
        Node temp = head;
        int m1 = m;
        int n1 = n;
    
        while (temp != null) {  
           
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                return;
            }

            Node current = temp.next;
            for (int i = 0; i < n && current != null; i++) {
                current = current.next;
            }
            temp.next = current;
            temp = current;
                    
    }
}
    
    public void AddFirst(int data) {

        // step:1 Create a newNode
        Node newNode = new Node(data);
        size++;

        // If linkedlist is empty than the first node itself head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step:2 newNode next =head
        newNode.next = head;

        // step:3 head = newNode
        head = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty!!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    //Swapping Nodes in a Linked List
    public void SwapLL(int x,int y){
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                temp.data = y;
            }else{
                temp.data = x;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        LinkedList_Example list = new LinkedList_Example();
        
        list.AddFirst(2);
        list.AddFirst(3);
        list.AddFirst(4);
        list.AddFirst(5);
        list.AddFirst(6);
        list.AddFirst(7);
        list.AddFirst(8);
        list.print();
        // list.DNM(2, 2);
        // list.print();
        list.SwapLL(2,4);
        list.print();
    }
}
