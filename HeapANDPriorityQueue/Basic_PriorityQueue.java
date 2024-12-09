package HeapANDPriorityQueue;
import java.util.*;

import HeapANDPriorityQueue.Basic_PriorityQueue.Student;

public class Basic_PriorityQueue {

    public static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;   //for sorting according to the rank
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Character>pq = new PriorityQueue<>();  //Add paramter: Comparator.reverseOrder()
        PriorityQueue<Student> objpq = new PriorityQueue<>();

        objpq.add(new Student("A", 4));
        objpq.add(new Student("B", 3));
        objpq.add(new Student("C", 6));
        objpq.add(new Student("D", 2));
        objpq.add(new Student("E", 1));

        /*E-->1
          D-->2
          B-->3
          A-->4
          C-->6 */

        while(!objpq.isEmpty()){
            System.out.println(objpq.peek().name+"-->"+objpq.peek().rank);
            objpq.remove();
        }

        
        //add operation ---> O(logN)
        pq.add('c');
        pq.add('a');
        pq.add('d');
        pq.add('b');

        while(!pq.isEmpty()){
            System.out.print(pq.peek());   //peek operation ---> O(1)
            pq.remove();  //remove operation -------> O(logN)
            // 1 2 3 5 (ascending order)
        }
    }
}
