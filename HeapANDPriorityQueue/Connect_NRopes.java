package HeapANDPriorityQueue;
import java.util.*;

public class Connect_NRopes {
    public static void main(String[] args) {
        int ropes[] = {2,3,3,4,6};
        int cost = 0;

        PriorityQueue<Integer> p =new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            p.add(ropes[i]);
        }

        while(p.size() > 1){
             int min1 = p.remove();
             int min2 = p.remove();
             cost = cost + (min1 + min2);
             p.add(min1 + min2);

        }

        System.out.println("Minimum cost to connect N ropes = " + cost);
    }
}
