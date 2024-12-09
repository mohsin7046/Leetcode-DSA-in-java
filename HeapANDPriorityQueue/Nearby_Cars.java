package HeapANDPriorityQueue;
import java.util.*;
public class Nearby_Cars {

    public static class Point implements Comparable<Point>{
        int carname;
        int x;
        int y;
        int distance;

        public Point(int carname,int x,int y, int distance){
            this.carname = carname;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point p2){
            return this.distance - p2.distance;
        }
    }
    public static void main(String[] args) {
        int arr [][] = {{3,3},{5,-1},{-2,4}};
        int k =2;
        PriorityQueue <Point> p = new PriorityQueue<>();

        //find the squr(distance) = x^2 + y^2
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            int distance = x*x + y*y;
           p.add(new Point(i, x, y, distance));
        }

        while(!p.isEmpty() && k > 0){
            System.out.println("C"+p.peek().carname+"-->"+p.peek().distance);
            p.remove();
            k--;
        }
    }
}
