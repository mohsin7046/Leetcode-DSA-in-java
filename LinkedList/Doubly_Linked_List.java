
package LinkedList;

class Doubly_Linked_List {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
   public static Node head;
   public static Node tail;
   public static int size;

   public void Add_First(int data) {
    Node newNode = new Node(data);
    size++;
      if (head == null) {
         head = tail = newNode;
      } else {
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
      }
   }

   public void print() {
      if (head == null) {
         System.out.println("LinkedList is empty!!");
      } 
      Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

         System.out.println("null");
      
   }

   public static void main(String[] var0) {
      Doubly_Linked_List var1 = new Doubly_Linked_List();
      var1.Add_First(10);
      var1.print();
      var1.Add_First(20);
      var1.print();
      var1.Add_First(30);
      var1.print();
   }
}



