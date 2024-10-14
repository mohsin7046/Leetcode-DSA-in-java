package Stack_Implementation;
import java.util.*;

public class Basic_Stack {

    //using ArrayList Implementation of stack
    static class Stack { 
      static ArrayList<Integer> list = new ArrayList<>();

      public static boolean isEmpty(){
        return list.size() == 0;
      }

      public static void push(int data){
        list.add(data);
      }

      public static int pop(){
        int top = list.get(list.size()-1);
        if(isEmpty()){
            return -1;
        }
        list.remove(list.size()-1);
        return top;
      }

      public static int peek(){
        return list.get(list.size()-1);
      }
    }




    //using LinkedList Implementation of Stack (top is always head because for making all operation like push ,pop in 0(1) complexity )
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack1 {
        static Node head = null;

        public static boolean isEmpty1(){
            return head == null;
        }

        public static void push1(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop1(){
            if(isEmpty1()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek1(){
            if (isEmpty1()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        Stack1 s1 = new Stack1();
        s1.push1(1);
        s1.push1(2);
        s1.push1(3);
        s1.push1(4);
        while (!s1.isEmpty1()) {
            System.out.println(s1.peek1());
            s1.pop1();
        }


        //Using inbuilt stack from javaCollection framework
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(3);
        while (!s.isEmpty()) {
            System.out.println(stack1.peek());
            stack1.pop();
        }
    }
}
