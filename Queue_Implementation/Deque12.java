package Queue_Implementation;
import java.util.*;

public class Deque12 {    //Double Ended Queue
    public static void main(String[] args) {
       Deque <Integer> de = new LinkedList<>();
       de.addFirst(1);
       de.addFirst(2);
       de.addFirst(3);
       de.addLast(4);
       System.out.println(de);
       de.removeFirst();
       de.removeLast();
       System.out.println(de);

       System.out.println(de.getFirst());
       System.out.println(de.getLast());
    }
}
