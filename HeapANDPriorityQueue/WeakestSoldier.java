package HeapANDPriorityQueue;

import java.util.PriorityQueue;

public class WeakestSoldier {
    public static class WeakRow implements Comparable<WeakRow>{
        int soldiercount;
        int index;

        public WeakRow(int soldiercount, int index){
            this.soldiercount = soldiercount;
            this.index = index;
        }

        @Override
        public int compareTo(WeakRow r2){
            if(this.soldiercount == r2.soldiercount){
                return this.index - r2.index;
            }
            return this.soldiercount - r2.soldiercount;
        }
    }
    public static void main(String[] args) {
        int army [][] = {{1,0,0,0},
                          {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}
                     };

       int k = 2;
       PriorityQueue<WeakRow> p = new PriorityQueue<>();
       
       for (int i = 0; i < army.length; i++) {
        int count = 0;
        for (int j = 0; j < army.length; j++) {
            count += army[i][j] == 1 ? 1:0;    
         }
         p.add(new WeakRow(count, i));
       }

       while (k > 0) {
        System.out.println("Row"+p.peek().index +"-->"+p.peek().soldiercount);
        p.remove();
        k--;
       }
    }
}
