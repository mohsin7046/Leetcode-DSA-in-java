package LinkedList;
import java.util.*;

public class Basic_linked_list {
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

    // Add first
    public void AddFirst(int data) {s

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


    // Add Last
    public void AddLast(int data) {

        // step:1 Create a newNode
        Node newNode = new Node(data);
        size++;

        // If linkedlist is empty than the first node itself head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step:2 tail next = newNode
        tail.next = newNode;

        // step:3 tail = newNode
        tail = newNode;

    }


    // Print linkedlist
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

    // Add at middle of LinkList
    public void AddMiddle(int idx, int data) {

        if (idx == 0) {
            AddFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove First
    public int RemoveFirst() {
        if (size == 0) {
            System.out.println("LL is empty!!");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove Last
    public int RemoveLast() {
        if (size == 0) {
            System.out.println("LL is empty!!");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // previous : i = size-2;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Search (Iteration)
    public int Search(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Recursive Search
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int index = helper(head.next, key); // if key found so it return 0 and else return -1
        if (index == -1) {
            return -1;
        }
        return index + 1;
    }

    public int RecursiveSearch(int key) {
        return helper(head, key);
    }

    // Reverse The LinkedList (Iterative method)
    public void ReverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Remove nth node from End
    public void DeleteNTHEnd(int n) {
        Node temp = head;
        int i = 1;
        int sz = 0; // for example to count the size

        while (temp != null) { // for counting the size of an LL
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next; // remove first node
            return;
        }

        // for sz-n
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // Check if LinkedList is Palindrom or not
    public boolean Palindrom() {
        if (head == null || head.next == null) {  // if only one value in ll
            return true;
        }
        // step:1 find the mid
        Node midNode = FindMid(head);

        // step:2 Reverse the 2nd half of the linkedlist
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // Head of the right part
        Node left = head; // Head of the left part

        // Check If left(1st half) == Right(2nd half)
        while (right != null) {
            if (left.data != right.data) {
                return false;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        return true;
    }

    // To find MidValue using Slow-Fast pointer technique
    public Node FindMid(Node head) { // helper function
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Detect a loop/cycle in a LinkedList (Using Floyd's Cycle finding ALGO) ==>
    // Slow/Fast Pointer Approach
    public boolean CheckCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    // Remove the cycle/loop from the LinkedList
    public void RemoveCycle() {
        // Detect the cycle
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        // find meeting point(slow==fast)
        slow = head;
        Node prev = null;   //It store the last node (make prev.next=null)
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle (lastnode.next = null)
        prev.next = null;
    }



    // Merge Sort on LinkedList
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node MergeSortLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //mid
        Node mid = getMid(head);
    
        // call MergeSort for left and right half
        Node rightHead = mid.next;
        mid.next = null;
       Node newLeft = MergeSortLL(head);  //for left
       Node newRight = MergeSortLL(rightHead);  //for right

        //Merge 
        return Merge(newLeft,newRight);
    }

    public Node Merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 !=null && head2!=null) {
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {   //If only left element is remain
            temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
        }

        while (head2 != null) {  //If only right element is remain
            temp.next = head2;
                head1 = head2.next;
                temp = temp.next;
        }

        return mergedLL.next;
    }


    //Zig-Zag LinkedList
    public void ZZ_Linkedlist(){
        //Step:1 Find Mid-Node
       Node slow = head;
       Node fast = head.next;

       while(fast != null || fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
       }

       Node midNodeZig = slow;

       //Step:2 Reverse the second-half
       Node prev = null;
       Node current = midNodeZig.next;
       midNodeZig.next = null;
       Node next;
       while(current!=null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
       }

       //Step:3 Alternate Merging
       Node righthead = prev;
       Node lefthead = head;
       Node nextleft;
       Node nextRight;
       
       while(lefthead!=null && righthead!=null){

          //zig-zag mapping with pointer
            nextleft=lefthead.next;
            lefthead.next = righthead;

            nextRight = righthead.next;
            righthead.next = nextleft;

            //update the pointer
            righthead = nextRight;
            lefthead = nextleft;
       }
      
    }

    public static void main(String[] args) {
        Basic_linked_list ll = new Basic_linked_list();

        
        ll.AddFirst(1);
        ll.AddFirst(2);
        ll.AddFirst(3);
        ll.AddFirst(4);
        ll.AddFirst(5);
        ll.AddFirst(6);
        ll.print();
        // ll.head = ll.MergeSortLL(ll.head);
        ll.ZZ_Linkedlist();
        ll.print();

        // System.out.println(ll.CheckCycle());

        // System.out.println(ll.Palindrom());
        // ll.AddFirst(2);
        // ll.print();
        // ll.AddLast(3);
        // ll.print();
        // ll.AddLast(4);
        // ll.print();

        // ll.AddMiddle(2,9);
        // ll.print();
        // ll.RemoveFirst();
        // ll.print();
        // ll.RemoveLast();
        // ll.print();
        // System.out.println(ll.Search(9)); //iterative method for searching
        // System.out.println(ll.RecursiveSearch(9)); // recursive method for searching
        // ll.ReverseLL(); //Iterative method for reverse LL(O(n))
        // ll.print();
        // ll.Palindrom();
    }
}
